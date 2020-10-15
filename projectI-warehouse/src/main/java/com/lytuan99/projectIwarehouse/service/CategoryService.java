package com.lytuan99.projectIwarehouse.service;


import com.lytuan99.projectIwarehouse.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategory();
    void addCategory(CategoryDTO categoryDTO);
    void addProductToCategory(Long idProduct, Long idCategory);
    void updateCategory(CategoryDTO categoryDTO, Long idcategory);
    void deleteCategory (Long idCategory);


}
