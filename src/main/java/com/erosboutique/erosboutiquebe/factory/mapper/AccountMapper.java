package com.erosboutique.erosboutiquebe.factory.mapper;

import com.erosboutique.erosboutiquebe.entity.Authority;
import com.erosboutique.erosboutiquebe.entity.UserEntity;
import com.erosboutique.erosboutiquebe.enumeration.AuthorityName;
import com.erosboutique.erosboutiquebe.model.Account;
import com.erosboutique.erosboutiquebe.dto.Role;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AccountMapper {

    private static Function<List<Role>, List<com.erosboutique.erosboutiquebe.model.Authority>> mapToAuthorityList = roles -> roles.stream().map(role -> {
        com.erosboutique.erosboutiquebe.model.Authority authority = new com.erosboutique.erosboutiquebe.model.Authority();
        authority.setAuthorityName(AuthorityName.valueOf(role.toString()));
        return authority;
    }).collect(Collectors.toList());

    public static final Function<com.erosboutique.erosboutiquebe.dto.Account, Account> mapToModel = dto -> {

        Account model = new Account();
        model.setUserName(dto.getUserName());
        model.setPassword(dto.getPassword());
        model.getAuthorities().addAll(mapToAuthorityList.apply(dto.getRoles()));
        return model;
    };

    private static Function<List<com.erosboutique.erosboutiquebe.model.Authority>, List<Authority>> mapToAuthorityEntity = authorities -> authorities.stream().map(authority -> {
        Authority authorityEntity = new Authority();
        authorityEntity.setName(authority.getAuthorityName());
        return authorityEntity;
    }).collect(Collectors.toList());

    public static final Function<Account, UserEntity> mapToEntity = account -> {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(account.getUserName());
        userEntity.setPassword(account.getPassword());
        userEntity.setAuthorities(mapToAuthorityEntity.apply(account.getAuthorities()));

        return userEntity;
    };

    private AccountMapper() {
        // hide constructor
    }


}




/*
   private AccountMapper(){
        // hide constructor
    }

    public static model.Account mapToModel(Account dto){

        com.fashion.fashionbe.model.Account model = new com.fashion.fashionbe.model.Account();
        model.setUserName(dto.getUserName());
        model.setPassword(dto.getPassword());

        return model;
    }

    public static UserEntity mapToEntity(com.fashion.fashionbe.model.Account account){

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(account.getUserName());
        userEntity.setPassword(account.getPassword());

        return userEntity;
    }
}
 */