package com.example.testproductservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageURL;
    private Category category;
}
