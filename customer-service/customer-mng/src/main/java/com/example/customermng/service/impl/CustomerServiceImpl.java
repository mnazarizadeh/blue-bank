package com.example.customermng.service.impl;

import com.example.customermng.exception.BusinessException;
import com.example.customermng.exception.CustomerNotFoundException;
import com.example.customermng.repository.CustomerRepository;
import com.example.customermng.service.CustomerService;
import com.example.customermng.service.mapper.CustomerServiceMapper;
import com.example.customermng.service.model.CustomerBriefInquiryModel;
import com.example.customermng.service.model.CustomerCreationModel;
import com.example.customermng.service.model.CustomerDetailResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository repository;

	private final CustomerServiceMapper mapper;

	@Override
	public CustomerDetailResult getBrief(CustomerBriefInquiryModel model) throws BusinessException {
		log.debug("gonna fetch customer by model: {}", model);
		return mapper.toCustomerBriefResult(repository.findById(model.getCustomerId())
				.orElseThrow(() -> new CustomerNotFoundException("customer not found by id: " + model.getCustomerId())));
	}

	@Override
	public CustomerDetailResult createCustomer(CustomerCreationModel model) {
		log.debug("gonna create customer from: {}", model);
		var customer = repository.save(mapper.toCustomer(model));
		return mapper.toCustomerBriefResult(customer);
	}
}
