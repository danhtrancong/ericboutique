package com.ericboutique.ericboutiquebe.factory.mapper;

import com.ericboutique.ericboutiquebe.entity.UserEntity;
import com.ericboutique.ericboutiquebe.enumeration.AuthorityName;
import com.ericboutique.ericboutiquebe.model.Account;
import com.ericboutique.ericboutiquebe.model.Authority;
import com.erosboutique.erosboutiquebe.dto.Role;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AccountMapper {

    private static Function<List<Role>, List<Authority>> mapToAuthorityList = roles -> roles.stream().map(role -> {
        Authority authority = new Authority();
        authority.setAuthorityName(AuthorityName.valueOf(role.toString()));
        return authority;
    }).collect(Collectors.toList());

    public static final Function<Account, com.ericboutique.ericboutiquebe.model.Account> mapToModel = dto -> {

        com.ericboutique.ericboutiquebe.model.Account model = new com.ericboutique.ericboutiquebe.model.Account();
        model.setUserName(dto.getUserName());
        model.setPassword(dto.getPassword());
        //    model.getAuthorities().addAll(mapToAuthorityList.apply(dto.getRoles()));
        return model;
    };

    private static Function<List<Authority>, List<com.ericboutique.ericboutiquebe.entity.Authority>> mapToAuthorityEntity = authorities -> authorities.stream().map(authority -> {
        com.ericboutique.ericboutiquebe.entity.Authority authorityEntity = new com.ericboutique.ericboutiquebe.entity.Authority();
        authorityEntity.setName(authority.getAuthorityName());
        return authorityEntity;
    }).collect(Collectors.toList());

    public static final Function<com.ericboutique.ericboutiquebe.model.Account, UserEntity> mapToEntity = account -> {
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