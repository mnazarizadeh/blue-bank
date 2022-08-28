package com.example.accountmng.handler.account;

import java.util.List;

import com.example.accountmng.domain.constant.AccountType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public record AccountCreatorContext(
		List<AccountCreatorStrategy> strategies) {

	public AccountCreatorStrategy getHandler(AccountType accountType) {
		return strategies.stream().filter(strategy -> strategy.getType().equals(accountType)).findAny()
				.orElseThrow(() -> new IllegalStateException("undefined account creator for account type: " + accountType));
	}

}
