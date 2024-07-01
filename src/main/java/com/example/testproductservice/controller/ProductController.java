package com.example.testproductservice.controller;

import com.example.testproductservice.DTO.CreateProductResponseDTO;
import com.example.testproductservice.DTO.FakeStoreProductDTO;
import com.example.testproductservice.DTO.ProductResponseDTO;
import com.example.testproductservice.model.Product;
import com.example.testproductservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    /************** Ist API************/
    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> dtoList = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        for (Product p : products) {
            dtoList.add(convertProducttoResponseDTO(p));
        }

        return dtoList;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") int id) {
        //path variable will take the value from url and assign it to the function
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        //conversion from product to dto
        ProductResponseDTO response = new ProductResponseDTO();
        return new ResponseEntity<>(response, HttpStatus.OK);
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
    public Product createProduct(@RequestBody CreateProductResponseDTO dto) {

        /*
        * things we need -
        * title
        * description
        * image
        * price
        * category
        * */
        Product p = productService.createProduct(dto.getTitle(), dto.getDescription(), dto.getPrice(),dto.getCategory(), dto.getImage());

        return p;
    }
}
