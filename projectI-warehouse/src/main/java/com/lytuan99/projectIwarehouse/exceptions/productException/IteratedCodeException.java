package com.lytuan99.projectIwarehouse.exceptions.productException;

public class IteratedCodeException extends RuntimeException {

    public IteratedCodeException(String code, String entityName){
        super("mã code " + code + " đã tồn tại trong danh sách " + entityName);
    }

}
