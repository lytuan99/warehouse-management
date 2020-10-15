package com.lytuan99.projectIwarehouse.repository;


import com.lytuan99.projectIwarehouse.entity.ReceiptEntity;
import com.lytuan99.projectIwarehouse.repository.custom.ReceiptRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<ReceiptEntity, Long>, ReceiptRepositoryCustom {
    @Transactional
    @Modifying
    @Query(value = "update receipts u set u.status = ? where u.id = ?",
            nativeQuery = true)
    int updateStatus(Integer status, Long bigInteger);

    @Transactional
    @Modifying
    @Query(value = "update receipts u set u.note = ?,u.tag=? where u.id = ?",
            nativeQuery = true)
    void updateNoteAndTag(String note, String tag, Long bigInteger);

    @Query("SELECT u FROM ReceiptEntity u WHERE u.code LIKE %:code%")
    List<ReceiptEntity> findByCodeTest(@Param("code") String code, Pageable pageable);

    List<ReceiptEntity> findByCodeContaining(String code, Pageable pageable);

    List<ReceiptEntity> findByCode(String code, Pageable pageable);

}
