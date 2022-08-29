package com.example.transactionmng.spec.response;

import java.util.List;

import com.example.transactionmng.spec.dto.TransactionDetailDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionDetailListResponse {

	private List<TransactionDetailDto> transactions;

}
