package com.lytuan99.projectIwarehouse.repository;


import com.lytuan99.projectIwarehouse.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @NotNull
    Page<ProductEntity> findAll(@NotNull Pageable paging);

    ProductEntity findDistinctFirstByNameAndColorAndSizeAndMaterial(String name, String color, String size, String material);

    ProductEntity findDistinctTopBySkuCode(String skuCode);

    Page<ProductEntity> findByNameContaining(String name, Pageable paging);

    Page<ProductEntity> findByNameContainingIgnoreCaseAndSkuCodeContainingIgnoreCaseAndStatusAndProducerContainingIgnoreCase(
            String name, String skuCode, Boolean status, String producer, Pageable paging);

    Page<ProductEntity> findByNameContainingIgnoreCaseAndSkuCodeContainingIgnoreCaseAndProducerContainingIgnoreCase(
            String name, String skuCode, String producer, Pageable paging);

    List<ProductEntity> findAllByCategoryId(Long idCategory);

}
