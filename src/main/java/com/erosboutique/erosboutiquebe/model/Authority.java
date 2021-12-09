package com.erosboutique.erosboutiquebe.model;

import com.erosboutique.erosboutiquebe.enumeration.AuthorityName;

public class Authority {

    private AuthorityName authorityName;

    public AuthorityName getAuthorityName(){
        return authorityName;
    }

    public void setAuthorityName(AuthorityName authorityName){
        this.authorityName = authorityName;
    }
}
