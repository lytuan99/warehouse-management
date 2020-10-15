package com.lytuan99.projectIwarehouse.util;

import com.lytuan99.projectIwarehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GenCodeAuto {

    @Autowired
    static ProductRepository productRepository;

    public static String genCode(Long idProduct){
        System.out.println("helo: " + idProduct);
        String code =  "SP00" + idProduct.toString();
        return code;
    }
}
