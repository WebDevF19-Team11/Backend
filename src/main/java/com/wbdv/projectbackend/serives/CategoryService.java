package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.model.Category;
import com.wbdv.projectbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category, Integer> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CrudRepository getRepository() {
        return categoryRepository;
    }
}