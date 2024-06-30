package com.example.testproductservice.controller;

import com.example.testproductservice.DTO.ProductResponseDTO;
import com.example.testproductservice.model.Product;
import com.example.testproductservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    //constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts() {
        return "All products";
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") int id) {
        //path variable will take the value from url and assign it to the function

        ProductResponseDTO dto = new ProductResponseDTO();
        Product product = productService.getProductById(id);
        //conversion from product to dto

        return convertProducttoResponseDTO(product);
    }

    private ProductResponseDTO convertProducttoResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setCategory(product.getCategory());
        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setImageURL(product.getImageURL());
        dto.setDescription(product.getDescription());
        dto.setTitle(product.getTitle());
        return dto;



    }

    @PostMapping("/products")
    public void createProduct() {

    }
}
