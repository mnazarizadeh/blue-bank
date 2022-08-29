package com.example.common.constant;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TransactionType {

	WITHDRAW(0), DEPOSIT(1);

	private final int value;

	@JsonCreator
	public static TransactionType fromValue(int value) {
		return Stream.of(TransactionType.values()).filter(type -> type.value == value).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("invalid transaction type found " + value));
	}

	@JsonValue
	public Integer getValue() {
		return value;
	}

}
