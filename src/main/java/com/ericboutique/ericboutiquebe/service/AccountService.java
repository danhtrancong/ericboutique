package com.ericboutique.ericboutiquebe.service;


import com.ericboutique.ericboutiquebe.model.Account;

public interface AccountService {
    Long create(Account account);

    boolean update(Account account);
}
