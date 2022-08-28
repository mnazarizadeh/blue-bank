package com.example.accountmng.spec.constant;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AccountType {

	CURRENT(0);

	private final int value;

	@JsonCreator
	public static AccountType fromValue(int value) {
		return Stream.of(AccountType.values()).filter(type -> type.value == value).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("invalid account type found " + value));
	}

	@JsonValue
	public Integer getValue() {
		return value;
	}

}
