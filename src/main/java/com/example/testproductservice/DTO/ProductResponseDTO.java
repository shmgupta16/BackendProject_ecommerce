package com.example.testproductservice.DTO;

import com.example.testproductservice.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageURL;
    private Category category;

}
