package com.example.transactionmng.service.transaction.model;

import com.example.transactionmng.domain.constant.TransactionStatus;
import com.example.transactionmng.domain.constant.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionDetail {

	private String trackingCode;

	private String accountIdentifier;

	private TransactionType type;

	private Long transactionDate;

	private double amount;

	private double finalBalance;

	private TransactionStatus status;

}
