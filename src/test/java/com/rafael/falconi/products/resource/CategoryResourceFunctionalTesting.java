package com.rafael.falconi.products.resource;

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
import com.rafael.falconi.products.resources.CategoryResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class CategoryResourceFunctionalTesting {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private RestService restService;
	private CategoryDto categoryDto;

	@Before
	public void before() {
		this.categoryDto = new CategoryDto("1",  "titl456e");
	}

	@Test
	public void testCreaCategory() {
		restService.restBuilder().path(CategoryResource.CATEGORIES).body(this.categoryDto).post().build();
	}
	
	@Test
	public void testPutCategory() {
		restService.restBuilder().path(CategoryResource.CATEGORIES).body(this.categoryDto).post().build();
		this.categoryDto.setCategory("tittlePut");
		restService.restBuilder().path(CategoryResource.CATEGORIES).path(CategoryResource.ID)
		.expand(this.categoryDto.getId()).body(this.categoryDto).put().build();
	}
	
	@Test
	public void testCategoryRead() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CategoryResource.CATEGORIES).path(CategoryResource.ID).expand("1").get().build();
		System.out.println("------------>" + json);
	}

	@Test
	public void testCategoryAll() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CategoryResource.CATEGORIES).get().build();
		System.out.println("------------>" + json);
	}

}
