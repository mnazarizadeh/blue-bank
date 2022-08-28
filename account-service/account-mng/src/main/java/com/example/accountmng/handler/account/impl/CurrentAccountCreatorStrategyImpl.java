package com.example.accountmng.handler.account.impl;

import com.example.accountmng.domain.Account;
import com.example.accountmng.domain.constant.AccountType;
import com.example.accountmng.handler.account.AccountCreatorStrategy;
import com.example.accountmng.handler.account.mapper.AccountCreatorStrategyMapper;
import com.example.accountmng.handler.account.model.AccountCreatorModel;
import com.example.accountmng.handler.account.model.AccountCreatorResult;
import com.example.accountmng.repository.AccountRepository;
import com.example.common.util.TrackingCodeProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrentAccountCreatorStrategyImpl implements AccountCreatorStrategy {

	private final AccountRepository repository;

	private final AccountCreatorStrategyMapper mapper;

	@Override
	public AccountType getType() {
		return AccountType.CURRENT;
	}

	@Override
	public AccountCreatorResult run(AccountCreatorModel model) {
		log.debug("gonna create current account for model -> [{}]", model);

		var account = createAccountEntity(model);

		return mapper.toAccountCreatorResult(repository.save(account));
	}

	private Account createAccountEntity(AccountCreatorModel model) {
		var account = new Account();
		account.setOwnerId(model.getCustomerId());
		account.setAccountIdentifier(TrackingCodeProvider.generate());
		return account;
	}

}
