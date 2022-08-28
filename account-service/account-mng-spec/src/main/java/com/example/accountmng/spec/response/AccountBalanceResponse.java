package com.example.accountmng.spec.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountBalanceResponse {

	private String accountIdentifier;

	private double balance;

}
