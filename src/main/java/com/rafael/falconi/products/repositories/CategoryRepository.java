package com.rafael.falconi.products.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rafael.falconi.products.documents.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

	public Category findById(String id);


}
