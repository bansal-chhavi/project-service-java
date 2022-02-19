package com.nagp.assignment.util;

import org.springframework.util.StringUtils;

/**
 * The Class ValidationUtil.
 */
public final class ValidationUtil {

	/**
	 * Private constructor.
	 */
	private ValidationUtil() {

	}

	/**
	 * Assert that variable is valid.
	 *
	 * @param arg     the argument to validate
	 * @param message the message if argument is invalid
	 */
	public static void assertValid(String arg, String message) {
		if (!StringUtils.hasText(arg)) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * Assert num gt zero.
	 *
	 * @param x       the x
	 * @param message the message
	 */
	public static void assertNumGtZero(long x, String message) {
		if (x <= 0) {
			throw new IllegalArgumentException(message);
		}
	}

}
