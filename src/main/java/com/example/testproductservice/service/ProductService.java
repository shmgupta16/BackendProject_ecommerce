package com.example.testproductservice.service;

import com.example.testproductservice.model.Product;

public interface ProductService {
    public Product getProductById(int id);
    public Product getAllProducts();

}
