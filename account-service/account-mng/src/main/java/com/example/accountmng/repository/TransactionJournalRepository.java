package com.example.accountmng.repository;

import com.example.accountmng.domain.TransactionJournal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionJournalRepository extends JpaRepository<TransactionJournal, Long> {
}
