package com.example.accountmng.api.web.mapper;

import com.example.accountmng.service.account.model.AccountBalanceResult;
import com.example.accountmng.service.account.model.AccountCreationModel;
import com.example.accountmng.service.account.model.AccountCreationResult;
import com.example.accountmng.service.account.model.UpdateAccountBalanceModel;
import com.example.accountmng.spec.request.AccountCreationRequest;
import com.example.accountmng.spec.request.UpdateBalanceRequest;
import com.example.accountmng.spec.response.AccountBalanceResponse;
import com.example.accountmng.spec.response.AccountBriefResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountResourceMapper {

	AccountCreationModel toAccountCreationModel(AccountCreationRequest request);

	AccountBriefResponse toAccountBriefResponse(AccountCreationResult result);

	AccountBalanceResponse AccountBalanceResponse(AccountBalanceResult result);

	UpdateAccountBalanceModel toUpdateAccountBalanceModel(UpdateBalanceRequest request);

}
