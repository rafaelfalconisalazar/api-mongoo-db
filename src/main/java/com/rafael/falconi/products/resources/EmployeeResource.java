package com.rafael.falconi.products.resources;

import com.rafael.falconi.products.controllers.EmployeeController;
import com.rafael.falconi.products.dtos.EmployeeDto;
import com.rafael.falconi.products.resources.exeptions.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(EmployeeResource.AUTH)
public class EmployeeResource {

    public static final String AUTH="/auth";
    public static final String LOGIN="/login";
    public static final String SIGIN="/sigin";

    @Autowired
    private EmployeeController employeeController;

    @PostMapping(value = LOGIN)
    public String login(@Valid @RequestBody EmployeeDto employeeDto) throws LoginException{
        String data=this.employeeController.login(employeeDto);
        if(data=="no"){
            throw new LoginException();
        }else{
            return data;
        }
    }
    @PostMapping(value=SIGIN)
    public void signin(@Valid @RequestBody EmployeeDto employeeDto){
        this.employeeController.createEmployee(employeeDto);
    }
}
