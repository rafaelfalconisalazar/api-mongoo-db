package com.rafael.falconi.products.dtos;


import com.rafael.falconi.products.documents.Product;

public class ProductDto {

    private String id;

    private CategoryDto category;

    private String name;

    private int price;

    public ProductDto(){}

    public ProductDto(String id, CategoryDto category, String name, int price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public ProductDto(Product product){
        this.id=product.getId();
        this.name=product.getName();
        this.price=product.getPrice();
        this.category= new CategoryDto(product.getCategory());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
