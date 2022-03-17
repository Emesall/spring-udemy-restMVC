package com.emesall.restmvc.service;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;

import com.emesall.restmvc.api.v1.mapper.CategoryMapper;
import com.emesall.restmvc.api.v1.model.CategoryDTO;
import com.emesall.restmvc.model.Category;
import com.emesall.restmvc.repositories.CategoryRepository;

class CategoryServiceImplTest {

	
	CategoryService categoryService;
	@Mock
	CategoryRepository categoryRepository;

	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);		
		categoryService=new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE);
	}

	@Test
	void testGetCategories() {
		//given
		List<Category> categories=new ArrayList<>();
		categories.add(new Category());
		categories.add(new Category());
		
		//when
		when(categoryRepository.findAll()).thenReturn(categories);
		List<CategoryDTO> categoryDTOS=categoryService.getCategories();
		//then
		Assertions.assertEquals(2, categoryDTOS.size() );
		
	}
	
	@Test
	void testGetCategoryByName() {
		//given
		Category category=new Category();
		category.setName("name");
		category.setId(1L);
		//when
		when(categoryRepository.findByName(anyString())).thenReturn(category);
		CategoryDTO categoryDTO=categoryService.getCategory("name");
		//then
		Assertions.assertNotNull(categoryDTO);
		Assertions.assertEquals("name", categoryDTO.getName() );
		Assertions.assertEquals(1L, categoryDTO.getId() );
		
	}

}
