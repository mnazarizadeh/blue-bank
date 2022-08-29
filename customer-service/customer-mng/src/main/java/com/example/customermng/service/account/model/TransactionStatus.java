package com.example.customermng.service.account.model;

import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionStatus {

	PENDING(0), PAID(1), VERIFIED(2), FAILED(3), REVERSED(4);

	private final int value;

	public static TransactionStatus fromValue(int value) {
		return Stream.of(TransactionStatus.values()).filter(type -> type.getValue() == value).findFirst()
				.orElseThrow(() -> new IllegalStateException("undefined transaction status found: " + value));

	}
}
