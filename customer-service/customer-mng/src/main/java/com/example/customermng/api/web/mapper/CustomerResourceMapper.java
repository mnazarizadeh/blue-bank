package com.example.customermng.api.web.mapper;

import com.example.customermng.service.model.CustomerBriefInquiryModel;
import com.example.customermng.service.model.CustomerCreationModel;
import com.example.customermng.service.model.CustomerDetailResult;
import com.example.customermng.spec.request.CustomerCreationRequest;
import com.example.customermng.spec.response.CustomerBriefResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerResourceMapper {

	@Mapping(target = "customerIdentifier", source = "customerIdentifier")
	CustomerBriefInquiryModel toCustomerBriefInquiryModel(String customerIdentifier);

	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "birthDate", source = "birthDate")
	@Mapping(target = "socialId", source = "socialId")
	@Mapping(target = "customerIdentifier", source = "customerIdentifier")
	CustomerBriefResponse toCustomerBriefResponse(CustomerDetailResult result);

	CustomerCreationModel toCustomerCreationModel(CustomerCreationRequest request);
}
