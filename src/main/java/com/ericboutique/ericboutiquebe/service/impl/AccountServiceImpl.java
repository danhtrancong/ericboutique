package com.ericboutique.ericboutiquebe.service.impl;

import com.ericboutique.ericboutiquebe.entity.UserEntity;
import com.ericboutique.ericboutiquebe.factory.CommonUtility;
import com.ericboutique.ericboutiquebe.repository.AuthorityRepository;
import com.ericboutique.ericboutiquebe.repository.UserRepository;
import com.ericboutique.ericboutiquebe.service.AccountService;
import com.erosboutique.erosboutiquebe.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private CommonUtility commonUtility;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long create(Account account) {

        UserEntity userEntity = Account

        return 1;

    }

    @Override
    public boolean update(Account account) {
        return false;
    }
}
