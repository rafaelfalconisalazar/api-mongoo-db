package com.rafael.falconi.products.repositories;

import com.rafael.falconi.products.documents.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria,String> {
}
