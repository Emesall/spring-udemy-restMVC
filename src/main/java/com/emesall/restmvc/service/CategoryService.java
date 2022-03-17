package com.emesall.restmvc.service;

import java.util.List;

import com.emesall.restmvc.api.v1.model.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getCategories();
	CategoryDTO getCategory(String name);
}
