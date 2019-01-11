package com.javacourse.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessagesManager {
    private MessagesManager() {
    }

    public static String getProperty(HttpServletRequest request, String key) {
        Locale locale = new Locale(request.getParameter("lang") != null ? request.getParameter("lang") : "en");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
        return resourceBundle.getString(key);
    }

}
