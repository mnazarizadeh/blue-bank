package com.example.customermng.service;

import com.example.common.exception.BusinessException;
import com.example.customermng.service.model.CustomerCreationModel;
import com.example.customermng.service.model.CustomerBriefInquiryModel;
import com.example.customermng.service.model.CustomerDetailResult;

public interface CustomerService {

	CustomerDetailResult getBrief(CustomerBriefInquiryModel model) throws BusinessException;

	CustomerDetailResult createCustomer(CustomerCreationModel model);

}
