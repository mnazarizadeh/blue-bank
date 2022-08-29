package com.example.customermng.service.account;

import com.example.common.exception.BusinessException;
import com.example.customermng.service.account.model.CustomerAccountsResult;

public interface AccountService {

	CustomerAccountsResult getCustomerAccounts(String customerIdentifier) throws BusinessException;

}
