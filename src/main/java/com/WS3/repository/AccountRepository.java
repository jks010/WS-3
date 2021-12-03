package com.WS3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WS3.model.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);
}
