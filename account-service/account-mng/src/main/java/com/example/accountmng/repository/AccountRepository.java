package com.example.accountmng.repository;

import java.util.Optional;
import java.util.Set;

import com.example.accountmng.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByAccountIdentifier(String accountIdentifier);

	Set<Account> findAllByOwnerId(String ownerId);

}
