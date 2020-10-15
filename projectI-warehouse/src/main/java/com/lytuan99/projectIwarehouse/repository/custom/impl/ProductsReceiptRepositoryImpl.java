package com.lytuan99.projectIwarehouse.repository.custom.impl;

import com.lytuan99.projectIwarehouse.entity.ProductsReceiptEntity;
import com.lytuan99.projectIwarehouse.repository.custom.ProductsReceiptRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@Repository
public class ProductsReceiptRepositoryImpl implements ProductsReceiptRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProductsReceiptEntity> listVarianReceipt(Long id) {
		String sqlproductreceipt = "SELECT * FROM productreceipts where receipt_id=" + id + "";
		Query query = entityManager.createNativeQuery(sqlproductreceipt.toString(), ProductsReceiptEntity.class);
		return query.getResultList();
	}

//	@Transactional
//	@Override
//	public void delete(Long id) {
//		String sql = "DELETE FROM varianreceipts WHERE receipt_id=" + id + "";
//		entityManager.createNativeQuery(sql.toString()).executeUpdate();
//	}
//
	@Override
	@Transactional
	public void update(Long id, Integer quantityold, Integer quantitynew) {
		Integer quantity = quantityold + quantitynew;
		String sql = "UPDATE products SET quantity =" + quantity + "  WHERE id = " + id + "";
		entityManager.createNativeQuery(sql.toString()).executeUpdate();
	}
	@Override
	@Transactional
	public void updatePrice(Long id, BigDecimal pricenew) {
		String sql = "UPDATE products SET price =" + pricenew + "  WHERE id = " + id + "";
		entityManager.createNativeQuery(sql.toString()).executeUpdate();
	}


}
