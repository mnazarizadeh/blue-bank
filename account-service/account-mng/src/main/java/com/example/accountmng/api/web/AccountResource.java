package com.example.accountmng.api.web;

import javax.validation.Valid;

import com.example.accountmng.api.web.mapper.AccountResourceMapper;
import com.example.accountmng.service.account.AccountService;
import com.example.accountmng.spec.request.AccountCreationRequest;
import com.example.accountmng.spec.request.UpdateBalanceRequest;
import com.example.accountmng.spec.response.AccountBalanceResponse;
import com.example.accountmng.spec.response.AccountBriefResponse;
import com.example.accountmng.spec.response.AccountDetailListResponse;
import com.example.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/accounts")
@RequiredArgsConstructor
public class AccountResource {

	private final AccountService service;

	private final AccountResourceMapper mapper;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountBriefResponse> createAccount(
			@Valid @RequestBody AccountCreationRequest request) throws BusinessException {
		log.info("got create account request for: [{}]", request);
		var model = mapper.toAccountCreationModel(request);
		var result = service.createAccount(model);
		log.debug("account created: [{}]", result);

		return ResponseEntity.ok(mapper.toAccountBriefResponse(result));
	}

	@GetMapping(path = "/{accountIdentifier}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountBalanceResponse> getBalance(@PathVariable String accountIdentifier) throws BusinessException {
		log.info("got account balance request for account: [{}]", accountIdentifier);

		var result = service.getBalance(accountIdentifier);
		log.debug("account balance result is: [{}]", result);

		return ResponseEntity.ok(mapper.AccountBalanceResponse(result));
	}

	@PutMapping(path = "/{accountIdentifier}/balance", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountBalanceResponse> updateBalance(@PathVariable String accountIdentifier,
			@RequestBody UpdateBalanceRequest request) throws BusinessException {
		log.info("got account update balance request for account: [{}], request: [{}]", accountIdentifier, request);

		var result = service.updateBalance(mapper.toAccountUpdateBalanceModel(request));
		log.debug("account balance result is: [{}]", result);

		return ResponseEntity.ok(mapper.AccountBalanceResponse(result));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDetailListResponse> getCustomerAccounts(@RequestParam("customer") String customerIdentifier)
			throws BusinessException {
		log.info("got customer accounts request of customer identifier: [{}]", customerIdentifier);

		var result = service.getCustomerAccounts(customerIdentifier);
		log.trace("account list: [{}]", result);

		return ResponseEntity.ok(mapper.toAccountDetailListResponse(result));
	}

}
