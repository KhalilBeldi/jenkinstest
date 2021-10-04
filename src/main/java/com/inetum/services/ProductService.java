package com.inetum.services;

import com.inetum.entities.Category;
import com.inetum.entities.Product;
import com.inetum.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository,CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Product newProduct(Product product,long id){

        Optional<Category> category = this.categoryService.getCategoryById(id);

        category.get().addProduct(product);

        product.setCategory(category.get());

        return this.productRepository.save(product);

    }

    public Optional<Product> getProductById(long id){
        return this.productRepository.findById(id);
    }

    public Product updateProduct(Product productRequest,long id){

        Optional<Product> product = this.getProductById(id);

        product.get().setName(productRequest.getName());
        product.get().setQuantity(productRequest.getQuantity());
        product.get().setDisponibility(productRequest.getDisponibility());

        return this.productRepository.save(product.get());
    }

    public void deleteProduct(long id){
        this.productRepository.deleteById(id);
    }


    public List<Product> getProductListByCategory(long id){
        Optional<Category> category = this.categoryService.getCategoryById(id);
        return category.get().getProductList();
    }


}
