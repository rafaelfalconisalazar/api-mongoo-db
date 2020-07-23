package com.rafael.falconi.products.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {
    @Id
    private String id;

    private String category;

    public Category() {

    }

    public Category(int rank, String category) {
        this.category = category;
    }

    public Category(String id,String category) {
        super();
        this.id = id;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}