package com.rafael.falconi.products.controllers;

import com.rafael.falconi.products.documents.Deparment;
import com.rafael.falconi.products.documents.Employee;
import com.rafael.falconi.products.dtos.DeparmentDto;
import com.rafael.falconi.products.dtos.EmployeeDto;
import com.rafael.falconi.products.repositories.DeparmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DeparmentController {
    @Autowired
    DeparmentRepository deparmentRepository;

    public void createDeparment(DeparmentDto deparmentDto){
        Deparment deparment= new Deparment();
        deparment.setId(deparmentDto.getId());
        deparment.setName(deparmentDto.getName());
        List<Employee> employees= new ArrayList<Employee>();
        for (EmployeeDto employeeDto:
             deparmentDto.getEmployeeDtos()) {
            employees.add(new Employee(employeeDto.getId(),
                    employeeDto.getEmail(),employeeDto.getName(),employeeDto.getPassword()));
        }
        deparment.setEmployees(employees);
        this.deparmentRepository.save(deparment);
    }

    public List<DeparmentDto> listAllDeparments(){
        List<Deparment> deparmentList= this.deparmentRepository.findAll();
        List<DeparmentDto> deparmentDtoList= new ArrayList<DeparmentDto>();
        for (Deparment deparment:
             deparmentList) {
            deparmentDtoList.add(new DeparmentDto(deparment));
        }
        return  deparmentDtoList;
    }

    public Optional<List<EmployeeDto>> listEmployeeFromDeparment(String id){
        Deparment deparment=this.deparmentRepository.findOne(id);
        if(deparment==null){
            return Optional.empty();
        }
        List<EmployeeDto> employeeDtos= new ArrayList<EmployeeDto>();
        for (Employee employee:
             deparment.getEmployees()) {
            employeeDtos.add(new EmployeeDto(employee));

        }
        return  Optional.of(employeeDtos);
    }




}
