package com.inetum.services;

import com.inetum.entities.Category;
import com.inetum.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void shouldReturnAllCategories() {

        List<Category> list = new ArrayList<>();

        Category cat1 = new Category();

        cat1.setId(1);
        cat1.setName("Informatique");


        Category cat2 = new Category();


        cat2.setId(2);
        cat2.setName("éléctroménager");

        list.add(cat1);
        list.add(cat2);

        given(categoryRepository.findAll()).willReturn(list);

        List<Category> expected = categoryService.getCategories();

        assertEquals(expected,list);
    }

    @Test
    void testCreateCategory(){


        Category category = new Category();

        category.setId(1L);
        category.setName("Informatique");

        when(categoryRepository.save(category)).thenReturn(category);

        assertThat(categoryService.addCategory(category)).isEqualTo(category);

    }

    @Test
    void shouldUpdateSuccesfully(){

        Category category = new Category();

        category.setId(1L);
        category.setName("Informatique");

        when(categoryRepository.getById(1L)).thenReturn(category);

        Category changes = new Category();
        changes.setId(1L);
        changes.setName("électroménager");

        when(categoryRepository.save(changes)).thenReturn(category);

        assertThat(categoryService.updateCategory(1L,changes)).isEqualTo(category);

    }

    @Test
    void findCategoryById(){

        final long id = 1L;

        Category category = new Category();
        category.setId(1L);
        category.setName("Info");

        given(categoryRepository.findById(id)).willReturn(Optional.of(category));

        final Optional<Category> expected = categoryService.getCategoryById(id);

        assertThat(expected).isNotNull();
    }

    @Test
    void shouldDelete(){

        final long id = 1L;

        categoryService.deleteCategory(id);

        verify(categoryRepository, times(1)).deleteById(id);

    }
}