package com.rafael.falconi.products.dtos;

import com.rafael.falconi.products.documents.Employee;

public class EmployeeDto {

    private String id, email,name,password;

    public EmployeeDto(){}

    public EmployeeDto(String id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public EmployeeDto(Employee employee){
        this.id=employee.getId();
        this.email=employee.getEmail();
        this.name=employee.getName();
        this.password=employee.getPassword();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
