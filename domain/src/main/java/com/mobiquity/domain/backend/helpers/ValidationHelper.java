package com.mobiquity.domain.backend.helpers;

import static java.util.regex.Pattern.compile;

public class ValidationHelper {

    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)\\.(\\S+)$";

    public static boolean isEmailPattern(String input) {
        return compile(EMAIL_PATTERN).matcher(input).matches();
    }
}
