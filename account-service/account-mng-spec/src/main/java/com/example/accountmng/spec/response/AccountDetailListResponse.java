package com.example.accountmng.spec.response;

import java.util.List;

import com.example.accountmng.spec.dto.AccountDetailDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDetailListResponse {

	private List<AccountDetailDto> accounts;

}
