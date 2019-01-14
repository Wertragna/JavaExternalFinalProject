package com.javacourse.user.applicant.status;

import java.util.EnumMap;
/**
 * A class for enum name of status database table
 */
public enum StatusName {
    UNDER_CONSIDERATION,
    ACCEPTED,
    DERIVED,
    INELIGIBLE;
    private final static  EnumMap<StatusName, String> names = new EnumMap<>(StatusName.class);
    static {
        names.put(UNDER_CONSIDERATION,"candidate under consideration");
        names.put(ACCEPTED, "candidate under consideration");
        names.put(DERIVED,"Derived");
        names.put(INELIGIBLE,"Ineligible");
    }

    public static EnumMap<StatusName, String> getNames() {
        return names;
    }
}
