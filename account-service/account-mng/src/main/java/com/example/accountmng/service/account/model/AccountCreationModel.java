package com.example.accountmng.service.account.model;

import com.example.accountmng.domain.constant.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountCreationModel {

	private Long customerId;

	private AccountType accountType;

	private double initialCredit;

}
