package com.wbdv.projectbackend.repository;

import com.wbdv.projectbackend.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
