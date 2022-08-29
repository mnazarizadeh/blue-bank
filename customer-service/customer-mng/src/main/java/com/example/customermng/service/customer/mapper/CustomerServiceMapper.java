package com.example.customermng.service.customer.mapper;

import com.example.common.util.TrackingCodeProvider;
import com.example.customermng.domain.Customer;
import com.example.customermng.service.account.model.CustomerAccountsResult;
import com.example.customermng.service.customer.model.CustomerBriefResult;
import com.example.customermng.service.customer.model.CustomerCreationModel;
import com.example.customermng.service.customer.model.CustomerDetailResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { TrackingCodeProvider.class })
public interface CustomerServiceMapper {

	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "birthDate", source = "birthDate")
	@Mapping(target = "socialId", source = "socialId")
	@Mapping(target = "customerIdentifier", source = "customerIdentifier")
	CustomerBriefResult toCustomerBriefResult(Customer customer);

	@Mapping(target = "customerIdentifier", expression = "java(TrackingCodeProvider.generate())")
	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "birthDate", source = "birthDate")
	@Mapping(target = "socialId", source = "socialId")
	Customer toCustomer(CustomerCreationModel model);

	CustomerDetailResult toCustomerDetailResult(CustomerBriefResult customerBrief, CustomerAccountsResult accounts);

}
