package com.example.accountmng.service.account;

import com.example.accountmng.service.account.model.AccountBalanceResult;
import com.example.accountmng.service.account.model.AccountCreationModel;
import com.example.accountmng.service.account.model.AccountCreationResult;
import com.example.accountmng.service.account.model.UpdateAccountBalanceModel;
import com.example.common.exception.BusinessException;

public interface AccountService {

	AccountCreationResult createAccount(AccountCreationModel model) throws BusinessException;

	AccountBalanceResult updateBalance(UpdateAccountBalanceModel model) throws BusinessException;

	AccountBalanceResult getBalance(String accountIdentifier) throws BusinessException;

}
