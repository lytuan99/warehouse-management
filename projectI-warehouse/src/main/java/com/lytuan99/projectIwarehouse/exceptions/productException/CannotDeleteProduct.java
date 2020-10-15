package com.lytuan99.projectIwarehouse.exceptions.productException;

public class CannotDeleteProduct extends RuntimeException{
    public CannotDeleteProduct(){
        super("không thể xóa sản phẩm này vì đã tạo hóa đơn!");
    }
}
