package com.rafael.falconi.products.resources;

import java.util.List;

import javax.validation.Valid;

import com.rafael.falconi.products.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.falconi.products.controllers.ProductController;
import com.rafael.falconi.products.resources.exeptions.ProductCodeNotFoundException;

@RestController
@RequestMapping(ProductResource.PRODUCTS)
public class ProductResource {

	public static final String PRODUCTS = "/products";
	public static final String ID = "/{id}";
	@Autowired
	private ProductController productController;

	@PutMapping(value = ID)
	public void putEmployee(@PathVariable String id, @Valid @RequestBody ProductDto productDto)
			throws ProductCodeNotFoundException {
		if (!this.productController.putProduct(id, productDto)) {
			throw new ProductCodeNotFoundException();
		}
	}

	@PostMapping
	public void createEmployee(@Valid @RequestBody ProductDto employeeDto) {
		this.productController.createProduct(employeeDto);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> readEmployeeAll() {
		return new ResponseEntity<>(this.productController.readAllProducts(), HttpStatus.OK);
	}

	@RequestMapping(value = ID, method = RequestMethod.GET)
	public ProductDto readCategory(@PathVariable String id) throws ProductCodeNotFoundException {
		return this.productController.readProductsById(id).orElseThrow(() -> new ProductCodeNotFoundException(id));

	}
}
