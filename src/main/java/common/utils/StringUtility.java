package common.utils;

import common.enums.StringComparasionMethod;
import org.apache.commons.lang3.StringUtils;

public class StringUtility {

    public static boolean compareStrings(String a, String b, StringComparasionMethod stringComparasionMethod){
        return compareStrings(a, b, stringComparasionMethod, false);
    }

    public static boolean compareStrings(String a, String b, StringComparasionMethod stringComparasionMethod, boolean ignoreCase) {
        return compareStrings(a, b, stringComparasionMethod, false);
    }

    public static boolean compareStrings(String a, String b, StringComparasionMethod stringComparasionMethod, boolean ignoreCase, boolean ignoreSpaces) {
        if (ignoreCase) {
            a = StringUtils.normalizeSpace(a);
            b = StringUtils.normalizeSpace(b);
        }
        return switch (stringComparasionMethod){
            case CONTAINS -> ignoreCase ? StringUtils.containsIgnoreCase(a, b) : StringUtils.contains(a, b);
            case EQUALS -> ignoreCase ? StringUtils.equalsIgnoreCase(a, b) : StringUtils.equals(a, b);
            case STARTS_WITH -> ignoreCase ? StringUtils.startsWithIgnoreCase(a, b) : StringUtils.startsWith(a, b);
        };
    }
}
