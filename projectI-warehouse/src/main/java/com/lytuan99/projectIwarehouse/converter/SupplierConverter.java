package com.lytuan99.projectIwarehouse.converter;

import com.lytuan99.projectIwarehouse.dto.ReceiptDTO;
import com.lytuan99.projectIwarehouse.dto.SupplierDTO;
import com.lytuan99.projectIwarehouse.entity.SupplierEntity;
import com.lytuan99.projectIwarehouse.util.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class SupplierConverter {
    @Autowired
    ReceiptConverter receiptConverter;

    public List<SupplierDTO> toDTOs(List<SupplierEntity> entity) {
        /*ModelMapper modelMapper = new ModelMapper();
        Type typelist = new TypeToken<List<SupplierDTO>>() {
        }.getType();
        List<SupplierDTO> dtoList = modelMapper.map(entity, typelist);*/
        ArrayList<SupplierDTO> dtoList = new ArrayList<SupplierDTO>();
        for (SupplierEntity ele:entity)
        {
            dtoList.add(toDTO(ele));
        }
        return dtoList;
    }

    public List<SupplierEntity> toEntities(List<SupplierDTO> dto) {
        ModelMapper modelMapper = new ModelMapper();
        Type typelist = new TypeToken<List<SupplierEntity>>() {
        }.getType();
        List<SupplierEntity> entityList = modelMapper.map(dto, typelist);
        return entityList;
    }

    // public SupplierDTO toDTO(SupplierEntity entity) {
    // ModelMapper modelMapper = new ModelMapper();
    // SupplierDTO dto = modelMapper.map(entity, SupplierDTO.class);
    // List<ReceiptDTO> receiptDTOS =
    // receiptConverter.convertEntityToDTOList(entity.getReceiptEntity());
    // dto.setReceiptDTOS(receiptDTOS);
    // return dto;
    // }

    public SupplierEntity toEntity(SupplierDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        SupplierEntity entity = modelMapper.map(dto, SupplierEntity.class);
        return entity;
    }

    public SupplierDTO toDTO(SupplierEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        SupplierDTO dto = modelMapper.map(entity, SupplierDTO.class);
        if (entity.getModifiedDate() != null)
            dto.setModifiedDate(DateTime.getDate(entity.getModifiedDate()));
        if (entity.getCreatedDate() != null)
            dto.setCreatedDate(DateTime.getDate(entity.getCreatedDate()));

        List<ReceiptDTO> receiptDTOS = receiptConverter.convertEntityToDTOList(entity.getGoodsReceiptEntity());
        dto.setReceiptDTOS(receiptDTOS);
        // 2 dong nay de map List<ReceiptEntity> -> List<ReceiptDTO>
        return dto;
    }

    public SupplierDTO convertToDTO(SupplierEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        SupplierDTO dto = modelMapper.map(entity, SupplierDTO.class);
        return dto;
    }

}
