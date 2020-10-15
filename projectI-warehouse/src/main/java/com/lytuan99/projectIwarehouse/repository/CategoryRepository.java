package com.lytuan99.projectIwarehouse.repository;

import com.lytuan99.projectIwarehouse.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
