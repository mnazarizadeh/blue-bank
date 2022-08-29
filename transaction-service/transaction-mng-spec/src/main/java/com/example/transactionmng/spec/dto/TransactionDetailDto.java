package com.example.transactionmng.spec.dto;

import com.example.transactionmng.spec.constant.TransactionStatus;
import com.example.transactionmng.spec.constant.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionDetailDto {

	private String trackingCode;

	private String accountIdentifier;

	private TransactionType type;

	private Long transactionDate;

	private double amount;

	private double finalBalance;

	private TransactionStatus status;

}
