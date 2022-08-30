package com.example.transactionmng.client.account;

import com.example.accountmng.spec.request.UpdateBalanceRequest;
import com.example.accountmng.spec.response.AccountBalanceResponse;
import com.example.common.exception.ClientException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "accountClient", url = "${account.base.url}")
public interface AccountClient {

	@GetMapping(path = "/api/accounts/{accountIdentifier}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
	AccountBalanceResponse getBalance(@PathVariable String accountIdentifier) throws ClientException;

	@PutMapping(path = "/api/accounts/{accountIdentifier}/balance", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	AccountBalanceResponse updateBalance(@PathVariable String accountIdentifier, @RequestBody UpdateBalanceRequest request)
			throws ClientException;

}
