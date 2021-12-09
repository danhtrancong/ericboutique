package com.erosboutique.erosboutiquebe.model;

import java.util.ArrayList;
import java.util.List;

public class Account{

    private Long id;

    private String userName;

    private String password;

    private List<Authority> authorities = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public List<Authority> getAuthorities(){
        return authorities;
    }
}
