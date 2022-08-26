package com.example.accountmng.client.customer.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import com.example.common.constant.ResponseCode;
import com.example.common.error.ErrorResponse;
import com.example.common.exception.ClientException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

@Slf4j
public class CustomerClientErrorDecoder extends ErrorDecoder.Default {

	private final ObjectMapper objectMapper;

	public CustomerClientErrorDecoder() {
		this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Override
	public Exception decode(String methodKey, Response response) {
		if (HttpStatus.BAD_GATEWAY.value() == response.status()
				|| HttpStatus.GATEWAY_TIMEOUT.value() == response.status()
				|| HttpStatus.SERVICE_UNAVAILABLE.value() == response.status()
				|| HttpStatus.INTERNAL_SERVER_ERROR.value() == response.status()) {
			return new ClientException(ResponseCode.END_POINT_TIMEOUT, getBodyAsString(response));
		}

		int statusCode = response.status();
		if (HttpStatus.resolve(statusCode).is4xxClientError() || HttpStatus.resolve(statusCode).is5xxServerError()) {
			return verify(read(response));
		}

		return super.decode(methodKey, response);
	}

	private ClientException verify(ErrorResponse response) {
		if (response == null || response.getResponseCode() == null) {
			return new ClientException(ResponseCode.BAD_RESPONSE, "");
		}

		return new ClientException(response.getResponseCode(), response.getMessage());
	}

	private ErrorResponse read(Response response) {
		try {
			return objectMapper.readValue(response.body().asReader(), ErrorResponse.class);
		} catch (IOException e) {
			log.error("couldn't parse ErrorResponse: {}", response);
			return null;
		}
	}

	@Nullable
	private String getBodyAsString(Response response) {
		try {
			return new BufferedReader(new InputStreamReader(response.body().asInputStream())).lines()
					.collect(Collectors.joining("\n"));
		} catch (Exception e) {
			return null;
		}
	}

}
