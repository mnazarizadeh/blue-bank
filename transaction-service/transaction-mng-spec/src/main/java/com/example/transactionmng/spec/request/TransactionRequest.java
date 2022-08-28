package com.example.transactionmng.spec.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.transactionmng.spec.constant.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionRequest {

	@NotBlank
	private String accountIdentifier;

	@NotNull
	private TransactionType type;

	@Positive
	private double amount;

}
