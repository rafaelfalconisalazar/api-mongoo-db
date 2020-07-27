package com.rafael.falconi.products.repositories;

import com.rafael.falconi.products.documents.Deparment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeparmentRepository extends MongoRepository<Deparment,String> {
}
