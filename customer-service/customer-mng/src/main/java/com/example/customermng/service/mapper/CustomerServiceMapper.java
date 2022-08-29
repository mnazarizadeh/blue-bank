package com.example.customermng.service.mapper;

import java.util.UUID;

import com.example.customermng.domain.Customer;
import com.example.customermng.service.model.CustomerCreationModel;
import com.example.customermng.service.model.CustomerDetailResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { UUID.class })
public interface CustomerServiceMapper {

	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "birthDate", source = "birthDate")
	@Mapping(target = "socialId", source = "socialId")
	@Mapping(target = "customerIdentifier", source = "customerIdentifier")
	CustomerDetailResult toCustomerBriefResult(Customer customer);

	@Mapping(target = "customerIdentifier", expression = "java(UUID.randomUUID().toString())")
	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "birthDate", source = "birthDate")
	@Mapping(target = "socialId", source = "socialId")
	Customer toCustomer(CustomerCreationModel model);

}
