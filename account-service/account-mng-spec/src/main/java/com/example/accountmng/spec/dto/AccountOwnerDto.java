package com.example.accountmng.spec.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountOwnerDto {

	private String firstName;

	private String lastName;

	private Date birthDate;

	private String socialId;

}
