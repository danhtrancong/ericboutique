package com.ericboutique.ericboutiquebe.service.impl;

import com.ericboutique.ericboutiquebe.entity.Authority;
import com.ericboutique.ericboutiquebe.entity.UserEntity;
import com.ericboutique.ericboutiquebe.enumeration.AuthorityName;
import com.ericboutique.ericboutiquebe.factory.CommonUtility;
import com.ericboutique.ericboutiquebe.factory.mapper.AccountMapper;
import com.ericboutique.ericboutiquebe.model.Account;
import com.ericboutique.ericboutiquebe.repository.AuthorityRepository;
import com.ericboutique.ericboutiquebe.repository.UserRepository;
import com.ericboutique.ericboutiquebe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private CommonUtility commonUtility;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long create(com.ericboutique.ericboutiquebe.model.Account account) {
        UserEntity userEntity = AccountMapper.mapToEntity.apply(account);

        List<Authority> authorities = authorityRepository.findByName(AuthorityName.ROLE_CUSTOMER);
        if(authorities.isEmpty()){
            throw  new IllegalArgumentException(String.format("The role [%s] not found", AuthorityName.ROLE_CUSTOMER.name()));

        }
        userEntity.setAuthorities(authorities);
        String encodedPassword = commonUtility.passwordEncoder().encode(account.getPassword());
        userEntity.setPassword(encodedPassword);
        UserEntity createdUser = userRepository.save(userEntity);
                return createdUser.getId();

    }

    @Override
    public boolean update(Account account) {
        return false;
    }
}
