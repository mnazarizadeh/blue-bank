package com.example.accountmng.client.customer;

import com.example.common.exception.ClientException;
import com.example.customermng.spec.response.CustomerBriefResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "customerClient", url = "${customer.base.url}")
public interface CustomerClient {

	@GetMapping(path = "/api/customers/{customerIdentifier}", produces = MediaType.APPLICATION_JSON_VALUE)
	CustomerBriefResponse getCustomer(@PathVariable String customerIdentifier) throws ClientException;

}
