package com.example.common.util;

import java.util.UUID;

public final class TrackingCodeProvider {

	private TrackingCodeProvider() {

	}

	public static String generate() {
		return String.valueOf(Math.abs(UUID.randomUUID().toString().hashCode())) + System.currentTimeMillis();
	}

}
