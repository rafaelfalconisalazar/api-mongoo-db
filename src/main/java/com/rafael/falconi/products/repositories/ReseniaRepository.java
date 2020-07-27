package com.rafael.falconi.products.repositories;

import com.rafael.falconi.products.documents.Resenia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReseniaRepository extends MongoRepository<Resenia,String> {
}
