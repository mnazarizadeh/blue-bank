package com.example.accountmng.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.accountmng.domain.constant.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "acctounts")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "account_identifier", nullable = false, unique = true)
	private String accountIdentifier;

	@Column(name = "account_type", nullable = false)
	private AccountType type;

	@Column(name = "owner_id", nullable = false)
	private Long ownerId;

	@CreatedDate
	@Column(name = "opening_date", nullable = false)
	private Long openingDate;

	@Column(name = "balance", nullable = false)
	private double balance;

	@Column(name = "active", nullable = false)
	private boolean active;

	public Date getOpeningDate() {
		return new Date(openingDate);
	}

}
