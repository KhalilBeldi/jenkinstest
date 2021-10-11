package com.inetum.services;

import com.inetum.entities.Category;
import com.inetum.entities.Product;
import com.inetum.repositories.CategoryRepository;
import com.inetum.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {


    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductService productService;

    @InjectMocks
    private CategoryService categoryService;


    @Test
    void shouldDeleteProductSuccesfuly(){

        final long id = 1L;

        Category category = new Category();

        category.setId(1L);
        category.setName("Informatique");

        productService.deleteProduct(id);
        productService.deleteProduct(id);

        verify(productRepository, times(2)).deleteById(id);
    }

    @Test
    void shouldAddProductSuccesfuly(){



    }

    @Test
    void shouldUpdateProduct(){


    }

}