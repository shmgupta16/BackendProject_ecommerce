package com.example.testproductservice.service;

import com.example.testproductservice.DTO.FakeStoreProductDTO;
import com.example.testproductservice.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
    public List<Product> getAllProducts() {
       List<Product> products = new ArrayList<>();

       //step 1- call the Fakestore API
       FakeStoreProductDTO[] response = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);

       //step2 - converting the response
       for (FakeStoreProductDTO fakeStoreProductDTO : response) {
           products.add(FakeStoreProductDTO.toProduct());
       }
       return products;
    }

    @Override
    public Product createProduct(String title, String description, Double price, String category, String image) {
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();

        requestBody.setTitle(title);
        requestBody.setImage(image);
        requestBody.setDescription(description);
        requestBody.setPrice(price);
        requestBody.setCategory(category);

        FakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",requestBody, FakeStoreProductDTO.class);


        return FakeStoreProductDTO.toProduct();

    }


}
