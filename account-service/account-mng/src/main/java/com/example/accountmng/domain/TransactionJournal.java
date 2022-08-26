package com.example.accountmng.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.accountmng.domain.constant.TransactionStatus;
import com.example.accountmng.domain.constant.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "transaction_journals")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionJournal implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tracking_code", nullable = false, unique = true)
	private String trackingCode;

	@Column(name = "account_number", nullable = false)
	private String accountNumber;

	@Column(name = "transaction_type", nullable = false)
	private TransactionType type;

	@CreatedDate
	@Column(name = "transaction_date", nullable = false)
	private Long transactionDate;

	@Column(name = "amount", nullable = false)
	private double amount;

	@Column(name = "status", nullable = false)
	private TransactionStatus status;

	public Date getTransactionDate() {
		return new Date(transactionDate);
	}

}
