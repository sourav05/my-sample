package com.sample.shopping.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.shopping.inventory.category.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
