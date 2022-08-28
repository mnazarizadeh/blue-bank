package com.example.accountmng.service.customer.mapper;

import com.example.accountmng.service.customer.model.CustomerBriefResult;
import com.example.customermng.spec.response.CustomerBriefResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerServiceMapper {

	CustomerBriefResult toCustomerBriefResult(CustomerBriefResponse response);

}
