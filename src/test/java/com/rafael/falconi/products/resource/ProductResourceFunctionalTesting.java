package com.rafael.falconi.products.resource;

import com.rafael.falconi.products.dtos.ProductDto;
import com.rafael.falconi.products.resources.CategoryResource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rafael.falconi.products.dtos.CategoryDto;
import com.rafael.falconi.products.resources.ProductResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class ProductResourceFunctionalTesting {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private ProductDto productDto;
    private CategoryDto categoryDto;

    @Before
    public void before() {
        this.categoryDto = new CategoryDto("1", "rank4");
        this.productDto = new ProductDto("2", categoryDto, "aaa", 50);
    }

    @Test
    public void testCreateEmployee() {
        restService.restBuilder().path(ProductResource.PRODUCTS).body(this.productDto).post().build();
    }

    @Test
    public void testPutEmployee() {
        restService.restBuilder().path(ProductResource.PRODUCTS).body(this.productDto).post().build();
        this.productDto.setName("aa");
        restService.restBuilder().path(ProductResource.PRODUCTS).path(ProductResource.ID)
                .expand(this.productDto.getId()).body(this.productDto).put().build();
    }

    @Test
    public void testEmployeeAll() {
        String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
                .path(ProductResource.PRODUCTS).get().build();
        System.out.println("------>" + json);
    }

    @Test
    public void testEmployeeRead() {
        String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
                .path(ProductResource.PRODUCTS).path(ProductResource.ID).expand("1").get().build();
        System.out.println("------------>" + json);
    }

    @Override
    public String toString() {
        return "ProductResourceFunctionalTesting{" +
                "thrown=" + thrown +
                ", restService=" + restService +
                ", productDto=" + productDto +
                ", categoryDto=" + categoryDto +
                '}';
    }
}
