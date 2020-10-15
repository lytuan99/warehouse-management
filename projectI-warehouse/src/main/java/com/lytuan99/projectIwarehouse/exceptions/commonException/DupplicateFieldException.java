package com.lytuan99.projectIwarehouse.exceptions.commonException;

public class DupplicateFieldException extends RuntimeException{
    
    public DupplicateFieldException(String fieldName, String objectName)
    {
        super(fieldName + " của " + objectName +" bị trùng");
    }
}