package com.example.jwt.authorization.demo.jwt.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.authorization.demo.jwt.authorization.entity.JwtUser;

@Repository
public interface JwtUserRepository extends JpaRepository<JwtUser, String> {

}
