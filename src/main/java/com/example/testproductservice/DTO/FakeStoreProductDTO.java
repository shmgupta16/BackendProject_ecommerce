package com.example.testproductservice.DTO;

import com.example.testproductservice.model.Category;
import com.example.testproductservice.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class FakeStoreProductDTO {
    private static Integer id;
    private static String title;
    private static String price;
    private static String category;
    private static String description;
    private static String image;

    public static Product toProduct() {
        Product p = new Product();
        p.setDescription(description);
        p.setPrice(price);
        p.setImageURL(image);
        p.setTitle(title);
        p.setId(id);

        Category c = new Category();
        c.setId(Integer.valueOf(category));
        p.setCategory(c);
        return p;
    }

    public void setTitle(String title) {
    }

    public void setImage(String image) {
    }

    public void setDescription(String description) {
    }

    public void setPrice(Double price) {
    }

    public void setCategory(String category) {
    }
}
