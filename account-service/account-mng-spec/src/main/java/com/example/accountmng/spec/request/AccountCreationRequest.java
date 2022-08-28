package com.example.accountmng.spec.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.customermng.spec.constant.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountCreationRequest {

	@NotNull
	@Min(1)
	private Long customerId;

	@NotNull
	private AccountType type;

	private double initialCredit;

}
