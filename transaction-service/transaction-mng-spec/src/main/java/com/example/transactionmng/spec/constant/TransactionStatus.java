package com.example.transactionmng.spec.constant;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TransactionStatus {

	PENDING(0), FAILED(1), SUCCEED(2), REVERSED(3);

	private final int value;

	@JsonCreator
	public static TransactionStatus fromValue(int value) {
		return Stream.of(TransactionStatus.values()).filter(status -> status.value == value).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("invalid transaction status found " + value));
	}

	@JsonValue
	public Integer getValue() {
		return value;
	}

}
