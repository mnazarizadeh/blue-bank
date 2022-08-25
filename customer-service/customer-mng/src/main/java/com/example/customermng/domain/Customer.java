package com.example.customermng.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "birth_date", nullable = false)
	private Long birthDate;

	@Column(name = "social_id", nullable = false, unique = true)
	private String socialId;

	public Date getBirthDate() {
		return new Date(birthDate);
	}

	public void setBirthDate(Date birthDate) {
		if (Objects.nonNull(birthDate)) {
			this.birthDate = birthDate.getTime();
		}
	}
}
