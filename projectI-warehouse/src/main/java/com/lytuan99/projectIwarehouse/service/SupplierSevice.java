package com.lytuan99.projectIwarehouse.service;


import com.lytuan99.projectIwarehouse.dto.SupplierDTO;

import java.util.List;

public interface SupplierSevice {
    int getTotalItem();
    int getTotalItemFind(List<SupplierDTO> receiptDTOList);
}
