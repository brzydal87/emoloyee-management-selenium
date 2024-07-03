package common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StringComparasionMethod {
    CONTAINS("containing"),
    EQUALS("equals"),
    STARTS_WITH("starts with");

    public final String description;
}
