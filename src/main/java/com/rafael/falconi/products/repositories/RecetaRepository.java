package com.rafael.falconi.products.repositories;

import com.rafael.falconi.products.documents.Receta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecetaRepository extends MongoRepository<Receta,String> {
}
