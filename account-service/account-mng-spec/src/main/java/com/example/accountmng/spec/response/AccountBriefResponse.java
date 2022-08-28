package com.example.accountmng.spec.response;

import java.util.Date;

import com.example.accountmng.spec.dto.AccountOwnerDto;
import com.example.accountmng.spec.constant.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountBriefResponse {

	private String accountIdentifier;

	private AccountType accountType;

	private AccountOwnerDto owner;

	private Date openingDate;

	private double balance;

}
