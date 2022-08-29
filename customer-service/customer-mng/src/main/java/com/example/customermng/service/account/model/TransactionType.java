package com.example.customermng.service.account.model;

import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionType {

	WITHDRAW(0), DEPOSIT(1);

	private final int value;

	public static TransactionType fromValue(int value) {
		return Stream.of(TransactionType.values()).filter(type -> type.getValue() == value).findFirst()
				.orElseThrow(() -> new IllegalStateException("undefined transaction type found: " + value));

	}
}
