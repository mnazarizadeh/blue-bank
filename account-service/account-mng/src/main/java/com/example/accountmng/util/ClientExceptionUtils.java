package com.example.accountmng.util;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import javax.xml.bind.UnmarshalException;

import com.example.common.constant.ResponseCode;
import com.example.common.exception.ClientException;
import feign.FeignException.Unauthorized;
import org.apache.http.MalformedChunkCodingException;

public final class ClientExceptionUtils {

	private ClientExceptionUtils() {

	}

	public static ClientException deliver(Exception ex) throws ClientException {
		String responseCode = ResponseCode.UNKNOWN_ERROR;

		if (ex instanceof ClientException exception) {
			return exception;
		} else if (ex.getCause() instanceof MalformedChunkCodingException) {
			responseCode = ResponseCode.BAD_RESPONSE;
		} else if (ex.getCause() instanceof SocketTimeoutException) {
			responseCode = ResponseCode.TIMEOUT_ERROR;
		} else if (ex.getCause() instanceof UnmarshalException) {
			responseCode = ResponseCode.BAD_RESPONSE;
		} else if (ex.getCause() instanceof ConnectException) {
			responseCode = ResponseCode.CONNECTION_ERROR;
		} else if (ex.getCause() instanceof Unauthorized) {
			responseCode = ResponseCode.AUTHORIZATION_ERROR;
		}
		throw new ClientException(responseCode, ex.getMessage());
	}

}
