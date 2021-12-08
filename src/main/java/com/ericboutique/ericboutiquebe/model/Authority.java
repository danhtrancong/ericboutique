package com.ericboutique.ericboutiquebe.model;

import com.ericboutique.ericboutiquebe.enumeration.AuthorityName;

public class Authority {

    private AuthorityName authorityName;

    public AuthorityName getAuthorityName(){
        return authorityName;
    }

    public void setAuthorityName(AuthorityName authorityName){
        this.authorityName = authorityName;
    }
}
