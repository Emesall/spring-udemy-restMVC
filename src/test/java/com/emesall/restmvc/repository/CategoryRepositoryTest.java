package com.emesall.restmvc.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.emesall.restmvc.model.Category;
import com.emesall.restmvc.repositories.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTest {

	@Autowired
	CategoryRepository categoryRepository;

	@Test
	void testFindByName() {
		Category cat=new Category();
		cat.setName("test");
		categoryRepository.save(cat);
		Category category=categoryRepository.findByName("test");
		assertEquals("test", category.getName());
		
	}

}
