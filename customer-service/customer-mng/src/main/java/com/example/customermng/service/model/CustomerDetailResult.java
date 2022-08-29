package com.example.customermng.service.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDetailResult {

	private String customerIdentifier;

	private String firstName;

	private String lastName;

	private Date birthDate;

	private String socialId;

}
