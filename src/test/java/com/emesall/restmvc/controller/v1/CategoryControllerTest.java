package com.emesall.restmvc.controller.v1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.emesall.restmvc.api.v1.model.CategoryDTO;
import com.emesall.restmvc.service.CategoryService;

class CategoryControllerTest {

	@Mock
	CategoryService categoryService;
	@InjectMocks
	CategoryController categoryController;
	
	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(categoryController).build();
	}

	@Test
	void testGetCategories() throws Exception {
		// given
		List<CategoryDTO> category = new ArrayList<>();
		category.add(new CategoryDTO());
		category.add(new CategoryDTO());

		// when
		when(categoryService.getCategories()).thenReturn(category);

		// then
		mockMvc.perform(get("/api/v1/categories/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.categories", hasSize(2)));
	}

	@Test
	void testGetCategoryByName() throws Exception {
		// given
		CategoryDTO category = new CategoryDTO();
		category.setId(1L);
		category.setName("name");

		// when
		when(categoryService.getCategory(anyString())).thenReturn(category);

		// then
		mockMvc.perform(get("/api/v1/categories/name").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo("name")));
	}

}
