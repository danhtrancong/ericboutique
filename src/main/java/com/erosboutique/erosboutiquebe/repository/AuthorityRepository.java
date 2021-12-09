package com.erosboutique.erosboutiquebe.repository;

import com.erosboutique.erosboutiquebe.entity.Authority;
import com.erosboutique.erosboutiquebe.enumeration.AuthorityName;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    List<Authority> findByName(AuthorityName authorityName);
}
