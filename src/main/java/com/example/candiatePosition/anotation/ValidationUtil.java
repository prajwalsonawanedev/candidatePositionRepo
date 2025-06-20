package com.example.candiatePosition.anotation;

import io.micrometer.common.util.StringUtils;

public class ValidationUtil {

    private static String MOBILE_NUMBER_REGEX = "^[6-9]\\\\d{9}$";

    public static boolean isBlank(final String cs) {
        return StringUtils.isBlank(cs);
    }

    public static boolean isValidMobileNumber(String value) {
        return StringUtils.isNotEmpty(value) && !value.matches(MOBILE_NUMBER_REGEX);
    }
}