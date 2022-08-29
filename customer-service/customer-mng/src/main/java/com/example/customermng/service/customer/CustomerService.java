package com.example.customermng.service.customer;

import com.example.common.exception.BusinessException;
import com.example.customermng.service.customer.model.CustomerBriefResult;
import com.example.customermng.service.customer.model.CustomerCreationModel;
import com.example.customermng.service.customer.model.CustomerDetailResult;
import com.example.customermng.service.customer.model.CustomerInquiryModel;

public interface CustomerService {

	CustomerBriefResult getBrief(CustomerInquiryModel model) throws BusinessException;

	CustomerDetailResult getDetail(CustomerInquiryModel model) throws BusinessException;

	CustomerBriefResult createCustomer(CustomerCreationModel model);

}
