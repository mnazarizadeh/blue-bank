package com.example.accountmng.spec.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateBalanceRequest {

	private String accountIdentifier;

	private double amount;

}
