package com.sagar.oyoroomstest.utils;

/**
 * Created by Sagar on 23/02/2022.
 */
public class StringUtils {

    /**
     * Determine whether the string is null or all spaces
     *
     * @param s String to be verified
     * @return {@code true}: null or full space <br> {@code false}: not null and not all spaces
     */
    public static boolean isBlank(String s) {
        return (s == null || s.trim().length() == 0);
    }
}