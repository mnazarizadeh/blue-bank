package com.example.customermng.service.account.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerAccountsResult {

	private List<AccountDetail> accounts;

}
