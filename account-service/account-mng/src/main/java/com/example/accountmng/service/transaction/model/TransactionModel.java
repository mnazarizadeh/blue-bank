package com.example.accountmng.service.transaction.model;

import com.example.accountmng.domain.constant.TransactionType;

public record TransactionModel(String accountIdentifier, TransactionType type, double amount) {
}
