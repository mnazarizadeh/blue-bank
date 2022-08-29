package com.example.accountmng.service.transaction.model;

import java.util.Date;

import com.example.accountmng.domain.constant.TransactionStatus;
import com.example.accountmng.domain.constant.TransactionType;
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

	private Date transactionDate;

	private double amount;

	private double finalBalance;

	private TransactionStatus status;

}
