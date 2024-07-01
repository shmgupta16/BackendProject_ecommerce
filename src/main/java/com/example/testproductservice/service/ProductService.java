package com.example.testproductservice.service;

import com.example.testproductservice.model.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(int id);
    public List<Product> getAllProducts();
    public Product createProduct(String title , String description , Double price , String category , String image);

}
