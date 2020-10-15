package com.lytuan99.projectIwarehouse.converter;

import com.lytuan99.projectIwarehouse.dto.ReceiptDTO;
import com.lytuan99.projectIwarehouse.entity.ReceiptEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ReceiptConverter {
	public ReceiptDTO convertToDTO(ReceiptEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		ReceiptDTO dto=modelMapper.map(entity, ReceiptDTO.class);
		return dto;
	}
	public ReceiptEntity convertToEntity(ReceiptDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		ReceiptEntity entity=modelMapper.map(dto, ReceiptEntity.class);
		return entity;
	}
	public List<ReceiptDTO> convertEntityToDTOList(List<ReceiptEntity> entity)
	{
		ModelMapper modelMapper = new ModelMapper();
		Type typelist = new TypeToken<List<ReceiptDTO>>(){}.getType();
		List<ReceiptDTO> dtoList = modelMapper.map(entity, typelist);
		return dtoList;
	}
	public List<ReceiptEntity> convertDTOToEntityList(List<ReceiptDTO> dto)
	{
		ModelMapper modelMapper = new ModelMapper();
		Type typelist = new TypeToken<List<ReceiptEntity>>(){}.getType();
		List<ReceiptEntity> entityList = modelMapper.map(dto, typelist);
		return entityList;
	}
}
