package com.example.customermng.client.account;

import com.example.accountmng.spec.response.AccountDetailListResponse;
import com.example.common.exception.ClientException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "accountClient", url = "${account.base.url}")
public interface AccountClient {

	@GetMapping(path = "/api/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	AccountDetailListResponse getCustomerAccounts(@RequestParam("customer") String customerIdentifier)
			throws ClientException;

}
