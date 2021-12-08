package com.ericboutique.ericboutiquebe.repository;

import com.ericboutique.ericboutiquebe.entity.Authority;
import com.ericboutique.ericboutiquebe.enumeration.AuthorityName;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    List<Authority> findByName(AuthorityName authorityName);
}
