package com.lytuan99.projectIwarehouse.exceptions.receiptExeption;

public class ReceiptNotFoundException extends RuntimeException {
    public ReceiptNotFoundException(Long long1){
        super("Không tìm thấy đơn hàng có id : " + long1);
    }

    public ReceiptNotFoundException(String name){
        super("Không tìm thấy đơn hàng tên : " + name);
    }




}
