package com.erosboutique.erosboutiquebe.repository;

import com.erosboutique.erosboutiquebe.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
