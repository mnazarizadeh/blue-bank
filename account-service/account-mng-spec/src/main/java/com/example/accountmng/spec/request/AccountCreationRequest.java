package com.example.accountmng.spec.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.common.constant.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountCreationRequest {

	@NotBlank
	private String customerIdentifier;

	@NotNull
	private AccountType type;

	private double initialCredit;

}
