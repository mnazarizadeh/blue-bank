package com.example.accountmng.service.customer;

import com.example.accountmng.service.customer.model.CustomerBriefResult;
import com.example.common.exception.BusinessException;

public interface CustomerService {

	CustomerBriefResult getCustomer(String customerIdentifier) throws BusinessException;

}
