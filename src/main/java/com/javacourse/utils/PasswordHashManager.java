package com.javacourse.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHashManager {
    public static String hash( String password, String salt){
        return DigestUtils.sha256Hex(getSaltedPassword(password, salt));
    }
    private static String getSaltedPassword(String password, String salt){
        return password + salt;
    }
    public static boolean isExpectedPassword(String password, String salt, String expectedHash){
        String hash = hash(password, salt);
        return expectedHash.equals(hash);
    }
}
