package com.emesall.restmvc.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.emesall.restmvc.api.v1.model.CategoryDTO;
import com.emesall.restmvc.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	CategoryDTO categoryToCategoryDTO(Category category);
}
