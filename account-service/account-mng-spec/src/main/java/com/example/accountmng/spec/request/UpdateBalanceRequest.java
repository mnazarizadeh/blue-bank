package com.example.accountmng.spec.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateBalanceRequest {

	@NotBlank
	private String accountIdentifier;

	private double amount;

}
