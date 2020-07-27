package com.rafael.falconi.products.resources;

import com.rafael.falconi.products.dtos.CategoryDto;
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

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class EmployeeResourceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private EmployeeDto employeeDto;

    @Before
    public void before(){
        this.employeeDto= new EmployeeDto("2","email","nombre","password");
    }

    @Test
    public void login() {
        String json=restService.restBuilder(new RestBuilder<String>()).clazz(String.class).path(EmployeeResource.AUTH).path(EmployeeResource.LOGIN)
                .body(this.employeeDto).post().build();
        System.out.println(json);
    }

    @Test
    public void signin() {
        restService.restBuilder().path(EmployeeResource.AUTH).path(EmployeeResource.SIGIN)
                .body(this.employeeDto).post().build();
    }
}