package com.example.customermng.spec.response;

import java.util.Date;
import java.util.List;

import com.example.customermng.spec.dto.AccountDetailDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDetailResponse {

	private String customerIdentifier;

	private String firstName;

	private String lastName;

	private Date birthDate;

	private String socialId;

	private List<AccountDetailDto> accounts;

}
