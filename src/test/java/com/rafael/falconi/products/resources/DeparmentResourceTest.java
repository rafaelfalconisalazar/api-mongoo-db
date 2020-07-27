package com.rafael.falconi.products.resources;

import com.rafael.falconi.products.dtos.DeparmentDto;
import com.rafael.falconi.products.dtos.EmployeeDto;
import com.rafael.falconi.products.resource.RestBuilder;
import com.rafael.falconi.products.resource.RestService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class DeparmentResourceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private DeparmentDto deparmentDto;
    private EmployeeDto employeeDto;
    private EmployeeDto employeeDto2;

    @Before
    public void before(){
        this.employeeDto= new EmployeeDto("1","rfalconi@unibe.edu.ec","rafael","1234");
        this.employeeDto2= new EmployeeDto("2","rfalconi@unibe.edu.ec","rafael","1234");
        ArrayList<EmployeeDto>employeeDtos= new ArrayList<EmployeeDto>();
        employeeDtos.add(this.employeeDto);
        employeeDtos.add(this.employeeDto2);
        this.deparmentDto= new DeparmentDto();
        this.deparmentDto.setId("2");
        this.deparmentDto.setName("software");
        this.deparmentDto.setEmployeeDtos(employeeDtos);
    }

    @Test
    public void createDeparment() {
        restService.restBuilder().path(DeparmentResource.DEPARMENT).body(this.deparmentDto).post().build();
    }

    @Test
    public void getAllDeparments(){
        String json=restService.restBuilder(new RestBuilder<String>())
                .clazz(String.class).path(DeparmentResource.DEPARMENT)
                .get().build();
        System.out.println(json);
    }
    @Test
    public void getAllDeparmentsEmployee(){
        String json=restService.restBuilder(new RestBuilder<String>())
                .clazz(String.class).path(DeparmentResource.DEPARMENT)
                .path(DeparmentResource.EMPLOYEE).path(DeparmentResource.ID)
                .expand("2").get().build();
        System.out.println(json);
    }
}