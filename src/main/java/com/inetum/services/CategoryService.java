package com.inetum.services;

import com.inetum.entities.Category;
import com.inetum.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return this.categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(long id){

        return this.categoryRepository.findById(id);

    }

    public void deleteCategory(long id){
        categoryRepository.deleteById(id);
    }

    public Category addCategory(Category category){

        return categoryRepository.save(category);

    }

    public Category updateCategory(long id, Category category1){

        Category cat = this.categoryRepository.findById(id).get();

        if(!category1.getName().equals("")){
            cat.setName(category1.getName());
        }

        return this.categoryRepository.save(cat);

    }





}
