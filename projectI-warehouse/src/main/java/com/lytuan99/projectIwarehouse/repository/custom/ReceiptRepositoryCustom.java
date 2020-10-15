package com.lytuan99.projectIwarehouse.repository.custom;

import com.lytuan99.projectIwarehouse.dto.ReceiptSeachBuilder;
import com.lytuan99.projectIwarehouse.entity.ReceiptEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceiptRepositoryCustom {
	List<ReceiptEntity> listReceipt(Pageable page, ReceiptSeachBuilder receipt);
}
