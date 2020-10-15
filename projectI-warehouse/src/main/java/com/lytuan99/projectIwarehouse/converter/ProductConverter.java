package com.lytuan99.projectIwarehouse.converter;

import com.lytuan99.projectIwarehouse.dto.ProductDTO;
import com.lytuan99.projectIwarehouse.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;


@Component	
public class ProductConverter {
	public List<ProductEntity> convertDTOToEntityList(List<ProductDTO> dto){
		ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<ProductEntity>>(){}.getType();
        List<ProductEntity> postDTOList = modelMapper.map(dto, listType);
        return postDTOList;
    }
	public List<ProductDTO> convertEntityToDTOList(List<ProductEntity> dto){
		ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<ProductDTO>>(){}.getType();
        List<ProductDTO> postDTOList = modelMapper.map(dto, listType);
        return postDTOList;
    }
	public ProductDTO convertToDTO(ProductEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		ProductDTO dto=modelMapper.map(entity, ProductDTO.class);
//		ProductDTO dto=modelMapper.typeMap(entity).include(ProductDTO.class);
		return dto;
	}
	public ProductEntity convertToEntity(ProductDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		ProductEntity entity=modelMapper.map(dto, ProductEntity.class);
		return entity;
	}
}
