package com.example.accountmng.service.account.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountUpdateBalanceModel {

	private String accountIdentifier;

	private double amount;

}
