package com.example.transactionmng.service.transaction.model;

import com.example.transactionmng.domain.constant.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionInitiationModel {

	private String accountIdentifier;

	private TransactionType transactionType;

	private double amount;

}
