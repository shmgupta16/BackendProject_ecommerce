package com.example.testproductservice.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductResponseDTO {

    String title;
    Double price;
    String description;
    String image;
    String category;
}
