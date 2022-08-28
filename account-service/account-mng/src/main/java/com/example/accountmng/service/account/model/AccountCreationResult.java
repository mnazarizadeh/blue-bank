package com.example.accountmng.service.account.model;

import java.util.Date;

import com.example.accountmng.domain.constant.AccountType;
import com.example.accountmng.service.customer.model.CustomerBriefResult;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountCreationResult {

	private String accountIdentifier;

	private AccountType accountType;

	private CustomerBriefResult owner;

	private Date openingDate;

	private double balance;

}
