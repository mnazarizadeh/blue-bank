package com.example.customermng.service.account.model;

import java.util.Date;

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
