package com.rafael.falconi.products.repositories;

import com.rafael.falconi.products.documents.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    public Employee findEmployeeByEmail(String email);
}
