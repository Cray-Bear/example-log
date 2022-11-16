package com.fty1.example.log.repository;

import com.fty1.example.log.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
