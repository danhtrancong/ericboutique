package com.ericboutique.ericboutiquebe.repository;

import com.ericboutique.ericboutiquebe.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
