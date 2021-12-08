package com.ericboutique.ericboutiquebe.service.impl;

import com.ericboutique.ericboutiquebe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private CommonUtility  commonUtility;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long create(Account account){

    }
}
