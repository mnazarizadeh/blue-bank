package com.example.accountmng.domain.constant;

import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionType {

	DEBIT(0), CREDIT(1);

	private final int value;

	public static TransactionType fromValue(int value) {
		return Stream.of(TransactionType.values()).filter(type -> type.getValue() == value).findFirst()
				.orElseThrow(() -> new IllegalStateException("undefined transaction type found: " + value));

	}
}
