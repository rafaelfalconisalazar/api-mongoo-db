package com.rafael.falconi.products.repositories;

import com.rafael.falconi.products.documents.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
