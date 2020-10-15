package com.lytuan99.projectIwarehouse.exceptions.commonException;

public class NoDataException extends RuntimeException{
    
    public NoDataException()
    {
        super("Không có dữ liệu");
    }
}