package com.example.customermng.spec.dto;

import java.util.Date;
import java.util.List;

import com.example.common.constant.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDetailDto {

	private String accountIdentifier;

	private AccountType accountType;

	private Date openingDate;

	private String balance;

	private List<TransactionDetailDto> transactions;

}
