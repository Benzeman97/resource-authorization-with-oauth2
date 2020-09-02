package com.benz.mysql.exception;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String msg)
    {
        super(msg);
    }
}
