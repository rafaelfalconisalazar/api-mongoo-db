package com.rafael.falconi.products.resources;

import com.rafael.falconi.products.controllers.DeparmentController;
import com.rafael.falconi.products.dtos.DeparmentDto;
import com.rafael.falconi.products.dtos.EmployeeDto;
import com.rafael.falconi.products.resources.exeptions.CategoryCodeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(DeparmentResource.DEPARMENT)
public class DeparmentResource {
    public static  final String DEPARMENT="/deparments";
    public static  final String EMPLOYEE="/employees";
    public static  final String ID="/{id}";

    @Autowired
    private DeparmentController deparmentController;

    @PostMapping
    public void createDeparment(@Valid @RequestBody DeparmentDto deparmentDto){
        this.deparmentController.createDeparment(deparmentDto);
    }

    @GetMapping()
    public List<DeparmentDto> getAllDeparments(){
        return this.deparmentController.listAllDeparments();
    }
    @GetMapping(value = EMPLOYEE+ID)
    public List<EmployeeDto> getAllDeparmentsEmployees(@PathVariable String id) throws CategoryCodeNotFoundException {
        return this.deparmentController.listEmployeeFromDeparment(id).orElseThrow(()->new CategoryCodeNotFoundException());
    }
}
