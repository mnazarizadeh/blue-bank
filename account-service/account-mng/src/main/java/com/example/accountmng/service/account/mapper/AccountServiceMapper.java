package com.example.accountmng.service.account.mapper;

import com.example.accountmng.domain.Account;
import com.example.accountmng.handler.account.model.AccountCreatorModel;
import com.example.accountmng.service.account.model.AccountBalanceResult;
import com.example.accountmng.service.account.model.AccountCreationResult;
import com.example.accountmng.service.customer.model.CustomerBriefResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountServiceMapper {

	@Mapping(target = "customerId", source = "customerId")
	AccountCreatorModel toAccountCreatorModel(CustomerBriefResult customer);

	@Mapping(target = "accountIdentifier", source = "account.accountIdentifier")
	@Mapping(target = "accountType", source = "account.type")
	@Mapping(target = "owner", source = "customerInfo")
	@Mapping(target = "openingDate", source = "account.openingDate")
	@Mapping(target = "balance", source = "account.balance")
	AccountCreationResult toAccountCreationResult(Account account, CustomerBriefResult customerInfo);

	@Mapping(target = "accountIdentifier", source = "account.accountIdentifier")
	@Mapping(target = "balance", source = "account.balance")
	AccountBalanceResult toAccountBalanceResult(Account account);

}
