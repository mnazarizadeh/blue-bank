package com.example.transactionmng.repository;

import java.util.Optional;
import java.util.Set;

import com.example.transactionmng.domain.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Optional<Transaction> findByTrackingCode(String trackingCode);

	Set<Transaction> findByAccountIdentifier(String accountIdentifier);

}
