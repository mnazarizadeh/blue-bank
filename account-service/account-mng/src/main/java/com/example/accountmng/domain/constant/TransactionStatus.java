package com.example.accountmng.domain.constant;

import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionStatus {

	PENDING(0), FAILED(1), SUCCEED(2);

	private final int value;

	public static TransactionStatus fromValue(int value) {
		return Stream.of(TransactionStatus.values()).filter(type -> type.getValue() == value).findFirst()
				.orElseThrow(() -> new IllegalStateException("undefined transaction status found: " + value));

	}
}
