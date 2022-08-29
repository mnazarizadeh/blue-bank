package com.example.accountmng.client.transaction;

import com.example.common.exception.ClientException;
import com.example.transactionmng.spec.request.TransactionRequest;
import com.example.transactionmng.spec.response.TransactionBriefResponse;
import com.example.transactionmng.spec.response.TransactionDetailListResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "transactionClient", url = "${transaction.base.url}")
public interface TransactionClient {

	@PostMapping(path = "/api/transactions", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	TransactionBriefResponse initiateTransaction(@RequestBody TransactionRequest request)
			throws ClientException;

	@GetMapping(path = "/api/transactions/{trackingCode}/verify", produces = MediaType.APPLICATION_JSON_VALUE)
	TransactionBriefResponse verifyTransaction(@PathVariable String trackingCode)
			throws ClientException;

	@GetMapping(path = "/api/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
	TransactionDetailListResponse getAccountTransactions(@RequestParam("account") String accountIdentifier)
			throws ClientException;

}
