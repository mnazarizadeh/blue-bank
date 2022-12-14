package com.example.transactionmng.spec.response;

import com.example.common.constant.TransactionStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionBriefResponse {

	private String trackingCode;

	private TransactionStatus status;

}
