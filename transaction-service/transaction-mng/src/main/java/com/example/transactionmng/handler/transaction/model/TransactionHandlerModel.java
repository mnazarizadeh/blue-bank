package com.example.transactionmng.handler.transaction.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionHandlerModel {

	private String accountIdentifier;

	private double amount;

}
