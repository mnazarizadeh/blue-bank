package com.example.customermng.service.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerCreationModel {

	private String firstName;

	private String lastName;

	private String socialId;

	private Date birthDate;

}
