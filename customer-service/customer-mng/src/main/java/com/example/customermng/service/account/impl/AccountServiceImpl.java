package com.example.customermng.service.account.impl;

import com.example.common.exception.BusinessException;
import com.example.customermng.client.account.AccountClient;
import com.example.customermng.service.account.AccountService;
import com.example.customermng.service.account.mapper.AccountServiceMapper;
import com.example.customermng.service.account.model.CustomerAccountsResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountClient client;

	private final AccountServiceMapper mapper;

	@Override
	public CustomerAccountsResult getCustomerAccounts(String customerIdentifier) throws BusinessException {
		log.debug("gonna fetch accounts detail of customer -> [{}]", customerIdentifier);

		var response = client.getCustomerAccounts(customerIdentifier);

		return mapper.toCustomerAccountsResult(response);
	}

}
