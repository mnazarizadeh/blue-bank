package com.example.accountmng.service.customer.impl;

import com.example.accountmng.client.customer.CustomerClient;
import com.example.accountmng.service.customer.CustomerService;
import com.example.accountmng.service.customer.mapper.CustomerServiceMapper;
import com.example.accountmng.service.customer.model.CustomerBriefResult;
import com.example.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerClient client;

	private final CustomerServiceMapper mapper;

	@Override
	public CustomerBriefResult getCustomer(Long customerId) throws BusinessException {
		log.debug("gonna fetch customer info by id: [{}]", customerId);
		var response = client.getCustomer(customerId);
		return mapper.toCustomerBriefResult(response);
	}

}
