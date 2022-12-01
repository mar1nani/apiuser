package com.api.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
