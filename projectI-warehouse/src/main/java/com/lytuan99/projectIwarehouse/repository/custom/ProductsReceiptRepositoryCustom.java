package com.lytuan99.projectIwarehouse.repository.custom;


import com.lytuan99.projectIwarehouse.entity.ProductsReceiptEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ProductsReceiptRepositoryCustom {
	List<ProductsReceiptEntity> listVarianReceipt(Long id);
	void update(Long bigInteger, Integer quantityold, Integer quantitynew);
	void updatePrice(Long bigInteger, BigDecimal price);

}
