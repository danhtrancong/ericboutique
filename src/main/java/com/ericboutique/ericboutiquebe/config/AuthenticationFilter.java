package com.ericboutique.ericboutiquebe.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ericboutique.ericboutiquebe.factory.TokenHelper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

public class AuthenticationFilter extends OncePerRequestFilter{

    private UserDetailsService userDetailsService;

    private TokenHelper tokenHelper;

    public AuthenticationFilter(UserDetailsService userDetailsService, TokenHelper tokenHelper){
        this.userDetailsService = userDetailsService;
        this.tokenHelper = tokenHelper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException{
        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String token = null;

        // JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            token = requestTokenHeader.substring(7);
            try{
                username = tokenHelper.getUsernameFromToken(token);
            }catch(IllegalArgumentException e){
                System.out.println("Unable to get JWT Token");
            }catch(ExpiredJwtException e){
                System.out.println("JWT Token has expired");
            }
        }else{
            logger.warn("JWT Token does not begin with Bearer String");
        }

        // Once we get the token validate it.
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(tokenHelper.validateToken(token, userDetails)){
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
