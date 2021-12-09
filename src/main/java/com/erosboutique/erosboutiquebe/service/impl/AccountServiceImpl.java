package com.erosboutique.erosboutiquebe.service.impl;

import com.erosboutique.erosboutiquebe.entity.Authority;
import com.erosboutique.erosboutiquebe.entity.UserEntity;
import com.erosboutique.erosboutiquebe.enumeration.AuthorityName;
import com.erosboutique.erosboutiquebe.factory.CommonUtility;
import com.erosboutique.erosboutiquebe.factory.mapper.AccountMapper;
import com.erosboutique.erosboutiquebe.model.Account;
import com.erosboutique.erosboutiquebe.repository.AuthorityRepository;
import com.erosboutique.erosboutiquebe.repository.UserRepository;
import com.erosboutique.erosboutiquebe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private CommonUtility commonUtility;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private Function<List<Authority>, List<Authority>> findAuthoritiesByName = authorities -> {

        List<Authority> result = authorities.stream().map(authority -> {
            List<Authority> subAuthority = authorityRepository.findByName(authority.getName());
            return subAuthority.get(0);
        }).collect(Collectors.toList());

        if(result.isEmpty()){
            throw new IllegalArgumentException(String.format("The role [%s] not found", AuthorityName.ROLE_CUSTOMER.name()));
        }

        return result;
    };

    @Override
    public Long create(Account account){

        UserEntity userEntity = AccountMapper.mapToEntity.apply(account);

        List<Authority> authorities = findAuthoritiesByName.apply(userEntity.getRoles());
        userEntity.setAuthorities(authorities);

        String encodedPassword = commonUtility.passwordEncoder().encode(account.getPassword());
        userEntity.setPassword(encodedPassword);

        UserEntity createdUser = userRepository.save(userEntity);

        return createdUser.getId();
    }

}
