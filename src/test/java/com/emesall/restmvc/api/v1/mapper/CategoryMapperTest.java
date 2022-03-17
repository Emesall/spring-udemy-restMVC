package com.emesall.restmvc.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.emesall.restmvc.api.v1.model.CategoryDTO;
import com.emesall.restmvc.model.Category;
class CategoryMapperTest {

	CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
	public static final String NAME = "Joe";
	public static final long ID = 1L;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() throws Exception {
		// given
		Category category = new Category();
		category.setName(NAME);
		category.setId(ID);

		// when
		CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

		// then
		assertEquals(Long.valueOf(ID), categoryDTO.getId());
		assertEquals(NAME, categoryDTO.getName());
	}

}
