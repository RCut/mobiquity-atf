package com.mobiquity.domain.backend.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationHelper {

    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)\\.(\\S+)$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_PATTERN);

    public static boolean isEmailPattern(String input) {
        Matcher matcher = PATTERN.matcher(input);
        return matcher.matches();
    }

}
