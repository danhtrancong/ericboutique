package com.ericboutique.ericboutiquebe.factory;

import com.erosboutique.erosboutiquebe.dto.Problem;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CommonUtility {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Function<String, Problem> createProblem = errorMessage -> {
        Problem problem = new Problem();
        problem.setDetail(errorMessage);
        problem.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        problem.setTitle(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return problem;

    };
}
