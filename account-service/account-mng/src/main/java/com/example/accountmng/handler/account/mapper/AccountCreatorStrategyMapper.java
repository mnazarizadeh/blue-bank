package com.example.accountmng.handler.account.mapper;

import com.example.accountmng.domain.Account;
import com.example.accountmng.handler.account.model.AccountCreatorResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountCreatorStrategyMapper {

	AccountCreatorResult toAccountCreatorResult(Account account);

}
