package com.kodilla.hibernate.manytomany.facade;

public class SearchException extends Exception{

    public static String ERR_USER_NOT_FOUND = "User is not found";
    public static String ERR_COMPANY_NOT_FOUND = "Company is not found";

    public SearchException(String message) {
        super(message);
    }
}
