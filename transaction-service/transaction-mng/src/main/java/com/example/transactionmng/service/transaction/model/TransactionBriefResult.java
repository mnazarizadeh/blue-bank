package com.example.transactionmng.service.transaction.model;

import com.example.transactionmng.domain.constant.TransactionStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionBriefResult {

	private String trackingCode;

	private TransactionStatus status;

}
