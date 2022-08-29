package com.example.transactionmng.repository;

import java.util.Optional;

import com.example.transactionmng.domain.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Optional<Transaction> findByTrackingCode(String trackingCode);

}
