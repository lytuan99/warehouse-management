package com.lytuan99.projectIwarehouse.converter;

import com.google.common.reflect.TypeToken;
import com.lytuan99.projectIwarehouse.dto.ProductsReceiptDTO;
import com.lytuan99.projectIwarehouse.entity.ProductsReceiptEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;


@Component
public class ProductsReceiptConverter {
	public List<ProductsReceiptEntity> convertDTOToEntityList(List<ProductsReceiptDTO> dto){
		ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<ProductsReceiptEntity>>(){}.getType();
        List<ProductsReceiptEntity> postDTOList = modelMapper.map(dto, listType);
        return postDTOList;
    }
	public List<ProductsReceiptDTO> convertEntityToDTOList(List<ProductsReceiptEntity> dto){
		ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<ProductsReceiptDTO>>(){}.getType();
        List<ProductsReceiptDTO> postDTOList = modelMapper.map(dto, listType);
        return postDTOList;
    }
	public ProductsReceiptDTO convertToDTO(ProductsReceiptEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		ProductsReceiptDTO dto=modelMapper.map(entity, ProductsReceiptDTO.class);
		return dto;
	}
	public ProductsReceiptEntity convertToEntity(ProductsReceiptDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		ProductsReceiptEntity entity=modelMapper.map(dto, ProductsReceiptEntity.class);
		return entity;
	}
}
