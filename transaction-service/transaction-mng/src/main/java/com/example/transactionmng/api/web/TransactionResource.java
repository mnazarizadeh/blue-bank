package com.example.transactionmng.api.web;

import javax.validation.Valid;

import com.example.common.exception.BusinessException;
import com.example.transactionmng.api.web.mapper.TransactionResourceMapper;
import com.example.transactionmng.service.transaction.TransactionService;
import com.example.transactionmng.spec.request.TransactionRequest;
import com.example.transactionmng.spec.response.TransactionBriefResponse;
import com.example.transactionmng.spec.response.TransactionDetailListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/transactions")
@RequiredArgsConstructor
public class TransactionResource {

	private final TransactionService service;

	private final TransactionResourceMapper mapper;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionBriefResponse> initiateTransaction(
			@Valid @RequestBody TransactionRequest request) throws BusinessException {
		log.info("got initiate transaction request of: [{}]", request);

		var model = mapper.toTransactionInitiationModel(request);
		var result = service.initiateTransaction(model);
		log.debug("transaction initiated: [{}]", result);

		return ResponseEntity.ok(mapper.toTransactionBriefResponse(result));
	}

	@GetMapping(path = "/{trackingCode}/verify", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionBriefResponse> verifyTransaction(@PathVariable String trackingCode)
			throws BusinessException {
		log.info("got verify transaction request of tracking code: [{}]", trackingCode);

		var result = service.verifyTransaction(trackingCode);
		log.debug("transaction verified: [{}]", result);

		return ResponseEntity.ok(mapper.toTransactionBriefResponse(result));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionDetailListResponse> getAccountTransactions(@RequestParam("account") String accountIdentifier)
			throws BusinessException {
		log.info("got account transactions request of account identifier: [{}]", accountIdentifier);

		var result = service.getAccountTransactions(accountIdentifier);
		log.trace("transaction list: [{}]", result);

		return ResponseEntity.ok(mapper.toTransactionDetailListResponse(result));
	}

}
