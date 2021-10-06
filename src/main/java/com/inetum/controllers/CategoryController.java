package com.inetum.controllers;

import com.inetum.entities.Category;
import com.inetum.dto.CategoryDTO;
import com.inetum.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryService categoryService;

    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService,ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
    }

    @GetMapping(path="/{id}")
    public Optional<Category> getCategory(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }


    @PostMapping
    public ResponseEntity<CategoryDTO> newCategory(@RequestBody CategoryDTO categoryDTO){

        //convert dto to entity
        Category categoryRequest = modelMapper.map(categoryDTO, Category.class);

        Category category = this.categoryService.addCategory(categoryRequest);

        //convert entity to dto
        CategoryDTO categoryResponse = modelMapper.map(category, CategoryDTO.class);

        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);

    }

    @PutMapping(path = "{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable long id){

        Category categoryRequest = modelMapper.map(categoryDTO, Category.class);

        Category category = this.categoryService.updateCategory(id,categoryRequest);

        CategoryDTO categoryResponse = modelMapper.map(category, CategoryDTO.class);

        return ResponseEntity.ok().body(categoryResponse);

    }

}
