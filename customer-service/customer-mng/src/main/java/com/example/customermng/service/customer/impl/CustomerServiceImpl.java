package com.example.customermng.service.customer.impl;

import com.example.common.exception.BusinessException;
import com.example.customermng.exception.CustomerNotFoundException;
import com.example.customermng.repository.CustomerRepository;
import com.example.customermng.service.account.AccountService;
import com.example.customermng.service.customer.CustomerService;
import com.example.customermng.service.customer.mapper.CustomerServiceMapper;
import com.example.customermng.service.customer.model.CustomerDetailResult;
import com.example.customermng.service.customer.model.CustomerInquiryModel;
import com.example.customermng.service.customer.model.CustomerBriefResult;
import com.example.customermng.service.customer.model.CustomerCreationModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository repository;

	private final CustomerServiceMapper mapper;

	private final AccountService accountService;

	@Override
	public CustomerBriefResult getBrief(CustomerInquiryModel model) throws BusinessException {
		log.debug("gonna fetch customer by model: {}", model);
		return mapper.toCustomerBriefResult(repository.findByCustomerIdentifier(model.getCustomerIdentifier())
				.orElseThrow(() -> new CustomerNotFoundException("customer not found by id: " + model.getCustomerIdentifier())));
	}

	@Override
	public CustomerDetailResult getDetail(CustomerInquiryModel model) throws BusinessException {
		log.debug("gonna fetch customer detail by model: {}", model);
		var customerBrief = getBrief(model);
		var customerAccounts = accountService.getCustomerAccounts(model.getCustomerIdentifier());
		return mapper.toCustomerDetailResult(customerBrief, customerAccounts);
	}

	@Override
	public CustomerBriefResult createCustomer(CustomerCreationModel model) {
		log.debug("gonna create customer from: {}", model);
		var customer = repository.save(mapper.toCustomer(model));
		return mapper.toCustomerBriefResult(customer);
	}
}
