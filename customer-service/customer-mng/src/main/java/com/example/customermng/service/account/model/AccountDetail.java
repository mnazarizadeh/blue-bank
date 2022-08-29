package com.example.customermng.service.account.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDetail {

	private String accountIdentifier;

	private AccountType accountType;

	private Date openingDate;

	private double balance;

	private List<TransactionDetail> transactions;

}
