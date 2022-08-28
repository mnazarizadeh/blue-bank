package com.example.accountmng.repository;

import java.util.Optional;

import com.example.accountmng.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByAccountIdentifier(String accountIdentifier);

}
