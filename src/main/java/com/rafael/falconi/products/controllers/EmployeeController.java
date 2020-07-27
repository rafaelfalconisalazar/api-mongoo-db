package com.rafael.falconi.products.controllers;

import com.rafael.falconi.products.documents.Employee;
import com.rafael.falconi.products.dtos.EmployeeDto;
import com.rafael.falconi.products.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String login(EmployeeDto employeeDto){
        Employee employee= this.employeeRepository.findEmployeeByEmail(employeeDto.getEmail());
        if(employee==null) return "no";
        if(employee.getPassword().equals(employeeDto.getPassword())){
            return employeeDto.getId();
        }else{
            return "no";
        }

    }

    public void createEmployee(EmployeeDto employeeDto){
        Employee employee= new Employee(
                employeeDto.getId(),employeeDto.getEmail(),
                employeeDto.getName(),employeeDto.getPassword());
        this.employeeRepository.save(employee);
    }
}
