package com.javacourse.utils;

import java.util.ResourceBundle;

public class PathPageManager {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("webpages");

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
