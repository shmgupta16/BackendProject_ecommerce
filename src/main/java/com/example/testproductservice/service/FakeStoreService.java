package com.example.testproductservice.service;

import com.example.testproductservice.DTO.FakeStoreProductDTO;
import com.example.testproductservice.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service //if we annotate any class with service, spring will take care of the object creation
public class FakeStoreService implements ProductService{

    private final RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    @Override
    public Product getProductById(int id) {
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        return FakeStoreProductDTO.toProduct();
    }

    @Override
    public Product getAllProducts() {
        return null;
    }



}
