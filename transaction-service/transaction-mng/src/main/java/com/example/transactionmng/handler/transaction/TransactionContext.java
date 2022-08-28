package com.example.transactionmng.handler.transaction;

import java.util.List;

import com.example.transactionmng.domain.constant.TransactionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public record TransactionContext(
		List<TransactionStrategy> strategies) {

	public TransactionStrategy getHandler(TransactionType transactionType) {
		return strategies.stream().filter(strategy -> strategy.getType().equals(transactionType)).findAny()
				.orElseThrow(() -> new IllegalStateException("undefined transaction handler for account type: " + transactionType));
	}

}
