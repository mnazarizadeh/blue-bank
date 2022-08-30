package com.example.accountmng.api.web.mapper;

import com.example.accountmng.service.account.model.AccountBalanceResult;
import com.example.accountmng.service.account.model.AccountCreationModel;
import com.example.accountmng.service.account.model.AccountCreationResult;
import com.example.accountmng.service.account.model.AccountDetailListResult;
import com.example.accountmng.service.account.model.AccountUpdateBalanceModel;
import com.example.accountmng.spec.request.AccountCreationRequest;
import com.example.accountmng.spec.request.UpdateBalanceRequest;
import com.example.accountmng.spec.response.AccountBalanceResponse;
import com.example.accountmng.spec.response.AccountBriefResponse;
import com.example.accountmng.spec.response.AccountDetailListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountResourceMapper {

	@Mapping(target = "accountType", source = "type")
	AccountCreationModel toAccountCreationModel(AccountCreationRequest request);

	AccountBriefResponse toAccountBriefResponse(AccountCreationResult result);

	AccountBalanceResponse AccountBalanceResponse(AccountBalanceResult result);

	AccountUpdateBalanceModel toAccountUpdateBalanceModel(UpdateBalanceRequest request);

	AccountDetailListResponse toAccountDetailListResponse(AccountDetailListResult result);

}
