package com.example.customermng.service.account.mapper;

import com.example.accountmng.spec.response.AccountDetailListResponse;
import com.example.customermng.service.account.model.CustomerAccountsResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountServiceMapper {

	CustomerAccountsResult toCustomerAccountsResult(AccountDetailListResponse response);

}
