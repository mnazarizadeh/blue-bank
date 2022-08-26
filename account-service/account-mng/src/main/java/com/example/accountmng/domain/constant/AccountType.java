package com.example.accountmng.domain.constant;

import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountType {

	CURRENT(0);

	private final int value;

	public static AccountType fromValue(int value) {
		return Stream.of(AccountType.values()).filter(type -> type.getValue() == value).findFirst()
				.orElseThrow(() -> new IllegalStateException("undefined account type found: " + value));

	}
}
