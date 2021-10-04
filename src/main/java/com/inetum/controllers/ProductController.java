package com.inetum.controllers;

import com.inetum.entities.Product;
import com.inetum.dto.ProductDTO;
import com.inetum.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService,ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(path = "/add/{id}")
    public ResponseEntity<ProductDTO> addNewProduct(@RequestBody ProductDTO productDTO, @PathVariable long id){

        Product productRequest = modelMapper.map(productDTO,Product.class);

        Product product = this.productService.newProduct(productRequest,id);

        ProductDTO productResponse = modelMapper.map(product,ProductDTO.class);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable long id){

        Product productRequest = modelMapper.map(productDTO,Product.class);

        Product product = this.productService.updateProduct(productRequest,id);

        ProductDTO productResponse = modelMapper.map(product,ProductDTO.class);

        return ResponseEntity.ok().body(productResponse);

    }

    @GetMapping(path="/{id}")
    public Optional<Product> getProductById(@PathVariable long id){
        return this.productService.getProductById(id);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteProduct(@PathVariable long id){
        this.productService.deleteProduct(id);
    }

    @GetMapping(path = "/cat/{id}")
    public List<Product> getProductsByCategory(@PathVariable long id){
        return this.productService.getProductListByCategory(id);
    }

}
