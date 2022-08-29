package com.example.accountmng.service.account.model;

import java.util.Date;
import java.util.List;

import com.example.accountmng.domain.constant.AccountType;
import com.example.accountmng.service.transaction.model.TransactionDetail;
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
