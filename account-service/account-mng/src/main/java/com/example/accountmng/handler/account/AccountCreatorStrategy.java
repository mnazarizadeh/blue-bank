package com.example.accountmng.handler.account;

import com.example.accountmng.domain.constant.AccountType;
import com.example.accountmng.handler.account.model.AccountCreatorModel;
import com.example.accountmng.handler.account.model.AccountCreatorResult;

public interface AccountCreatorStrategy {

	AccountType getType();

	AccountCreatorResult run(AccountCreatorModel model);

}
