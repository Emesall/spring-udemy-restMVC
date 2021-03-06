package com.emesall.restmvc.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emesall.restmvc.api.v1.model.CategoryDTO;
import com.emesall.restmvc.api.v1.model.CategoryListDTO;
import com.emesall.restmvc.service.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public CategoryListDTO getCategories() {
		return new CategoryListDTO(categoryService.getCategories());
	}

	@GetMapping("{name}")
	@ResponseStatus(HttpStatus.OK)
	public CategoryDTO getCategoryByName(@PathVariable String name) {
		return categoryService.getCategory(name);
	}

}
