package com.example.customermng.api.web.mapper;

import com.example.customermng.service.customer.model.CustomerBriefResult;
import com.example.customermng.service.customer.model.CustomerCreationModel;
import com.example.customermng.service.customer.model.CustomerDetailResult;
import com.example.customermng.service.customer.model.CustomerInquiryModel;
import com.example.customermng.spec.request.CustomerCreationRequest;
import com.example.customermng.spec.response.CustomerBriefResponse;
import com.example.customermng.spec.response.CustomerDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerResourceMapper {

	@Mapping(target = "customerIdentifier", source = "customerIdentifier")
	CustomerInquiryModel toCustomerInquiryModel(String customerIdentifier);

	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "birthDate", source = "birthDate")
	@Mapping(target = "socialId", source = "socialId")
	@Mapping(target = "customerIdentifier", source = "customerIdentifier")
	CustomerBriefResponse toCustomerBriefResponse(CustomerBriefResult result);

	CustomerCreationModel toCustomerCreationModel(CustomerCreationRequest request);

	CustomerDetailResponse toCustomerDetailResponse(CustomerDetailResult result);

}
