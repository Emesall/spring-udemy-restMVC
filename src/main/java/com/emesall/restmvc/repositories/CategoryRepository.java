package com.emesall.restmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emesall.restmvc.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
