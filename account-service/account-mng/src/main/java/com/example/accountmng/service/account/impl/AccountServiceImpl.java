package com.example.accountmng.service.account.impl;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.example.accountmng.domain.Account;
import com.example.accountmng.domain.constant.TransactionType;
import com.example.accountmng.exception.AccountNotFoundException;
import com.example.accountmng.handler.account.AccountCreatorContext;
import com.example.accountmng.repository.AccountRepository;
import com.example.accountmng.service.account.AccountService;
import com.example.accountmng.service.account.mapper.AccountServiceMapper;
import com.example.accountmng.service.account.model.AccountBalanceResult;
import com.example.accountmng.service.account.model.AccountCreationModel;
import com.example.accountmng.service.account.model.AccountCreationResult;
import com.example.accountmng.service.account.model.UpdateAccountBalanceModel;
import com.example.accountmng.service.customer.CustomerService;
import com.example.accountmng.service.transaction.TransactionService;
import com.example.accountmng.service.transaction.model.TransactionModel;
import com.example.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountRepository repository;

	private final CustomerService customerService;

	private final TransactionService transactionService;

	private final AccountServiceMapper mapper;

	private final AccountCreatorContext context;


	@Override
	@Transactional(TxType.REQUIRES_NEW)
	public AccountCreationResult createAccount(AccountCreationModel model) throws BusinessException {
		log.debug("gonna create account with model -> [{}]", model);

		var customer = customerService.getCustomer(model.getCustomerId());
		var account = context.getHandler(model.getAccountType()).run(mapper.toAccountCreatorModel(customer));
		if (model.getInitialCredit() > 0) {
			transactionService.sendTransaction(
					new TransactionModel(account.getAccountIdentifier(),TransactionType.DEPOSIT, model.getInitialCredit()));
		}

		return mapper.toAccountCreationResult(getAccountByAccountIdentifier(account.getAccountIdentifier()), customer);
	}

	@Override
	public AccountBalanceResult updateBalance(UpdateAccountBalanceModel model) throws BusinessException {
		log.info("got update balance event for account -> [{}]", model.getAccountIdentifier());

		var account = getAccountByAccountIdentifier(model.getAccountIdentifier());
		account.setBalance(account.getBalance() + model.getAmount());
		return mapper.toAccountBalanceResult(repository.save(account));
	}

	@Override
	public AccountBalanceResult getBalance(String accountIdentifier) throws BusinessException {
		log.info("got balance update request for account -> [{}]", accountIdentifier);

		return mapper.toAccountBalanceResult(getAccountByAccountIdentifier(accountIdentifier));
	}

	private Account getAccountByAccountIdentifier(String accountIdentifier) throws BusinessException {
		return repository.findByAccountIdentifier(accountIdentifier)
				.orElseThrow(() -> new AccountNotFoundException("account not exists with account identifier: " + accountIdentifier))
	}
}