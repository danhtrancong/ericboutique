package com.erosboutique.erosboutiquebe.entity;

import com.erosboutique.erosboutiquebe.enumeration.AuthorityName;
import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

    private Long id;

    private AuthorityName name;

    public void setName(AuthorityName name){
        this.name = name;
    }

    @Override
    public String getAuthority(){
        return name.name();
    }

    public Long getId(){
        return id;
    }

    public AuthorityName getName(){
        return name;
    }

    public void setId(Long id){
        this.id = id;
    }
}
