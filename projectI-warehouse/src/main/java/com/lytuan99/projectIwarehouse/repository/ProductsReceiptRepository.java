package com.lytuan99.projectIwarehouse.repository;

import com.lytuan99.projectIwarehouse.entity.ProductsReceiptEntity;
import com.lytuan99.projectIwarehouse.repository.custom.ProductsReceiptRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsReceiptRepository  extends JpaRepository<ProductsReceiptEntity, Long>, ProductsReceiptRepositoryCustom {

}
