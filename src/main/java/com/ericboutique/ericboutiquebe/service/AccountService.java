package com.ericboutique.ericboutiquebe.service;

import com.erosboutique.erosboutiquebe.dto.Account;

public interface AccountService {
    Long create(Account account);

    boolean update(Account account);
}
