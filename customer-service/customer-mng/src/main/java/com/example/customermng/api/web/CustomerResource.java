package com.example.customermng.api.web;

import javax.validation.Valid;

import com.example.common.exception.BusinessException;
import com.example.customermng.api.web.mapper.CustomerResourceMapper;
import com.example.customermng.service.customer.CustomerService;
import com.example.customermng.spec.request.CustomerCreationRequest;
import com.example.customermng.spec.response.CustomerBriefResponse;
import com.example.customermng.spec.response.CustomerDetailResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/customers")
@RequiredArgsConstructor
public class CustomerResource {

	private final CustomerService service;

	private final CustomerResourceMapper mapper;

	@GetMapping(path = "/{customerIdentifier}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerBriefResponse> getBrief(@PathVariable String customerIdentifier) throws BusinessException {
		log.info("got customer brief request for customer identifier -> [{}]", customerIdentifier);
		var result = service.getBrief(mapper.toCustomerInquiryModel(customerIdentifier));
		return ResponseEntity.ok(mapper.toCustomerBriefResponse(result));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerBriefResponse> createCustomer(@Valid @RequestBody CustomerCreationRequest request) {
		log.info("got create customer request -> [{}]", request);
		var result = service.createCustomer(mapper.toCustomerCreationModel(request));
		return ResponseEntity.ok(mapper.toCustomerBriefResponse(result));
	}

	@GetMapping(path = "/{customerIdentifier}/detail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDetailResponse> getDetail(@PathVariable String customerIdentifier) throws BusinessException {
		log.info("got customer detail request for customer identifier -> [{}]", customerIdentifier);
		var result = service.getDetail(mapper.toCustomerInquiryModel(customerIdentifier));
		return ResponseEntity.ok(mapper.toCustomerDetailResponse(result));
	}

}
