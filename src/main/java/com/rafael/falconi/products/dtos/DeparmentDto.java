package com.rafael.falconi.products.dtos;

import com.rafael.falconi.products.documents.Deparment;
import com.rafael.falconi.products.documents.Employee;

import java.util.ArrayList;
import java.util.List;

public class DeparmentDto {

    private String id,name;

    private List<EmployeeDto> employeeDtos;

    public DeparmentDto(){}

    public DeparmentDto(String id, String name, List<EmployeeDto> employeeDtos) {
        this.id = id;
        this.name = name;
        this.employeeDtos = employeeDtos;
    }

    public  DeparmentDto(Deparment deparment){
        this.id=deparment.getId();
        this.name=deparment.getName();
        this.employeeDtos= new ArrayList<EmployeeDto>();
        for (Employee employee:
             deparment.getEmployees()) {
            this.employeeDtos.add(new EmployeeDto(employee));
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeDto> getEmployeeDtos() {
        return employeeDtos;
    }

    public void setEmployeeDtos(List<EmployeeDto> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }
}
