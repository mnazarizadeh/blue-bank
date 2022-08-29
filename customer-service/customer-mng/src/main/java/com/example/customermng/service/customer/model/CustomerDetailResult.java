package com.example.customermng.service.customer.model;

import java.util.List;

import com.example.customermng.service.account.model.AccountDetail;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDetailResult extends CustomerBriefResult {

	private List<AccountDetail> accounts;

}
