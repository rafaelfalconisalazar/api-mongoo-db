package com.rafael.falconi.products.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rafael.falconi.products.documents.Product;
import com.rafael.falconi.products.dtos.ProductDto;
import com.rafael.falconi.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rafael.falconi.products.documents.Category;
import com.rafael.falconi.products.repositories.CategoryRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	public void createProduct(ProductDto productDto) {
		Category category = this.categoryRepository.findById(productDto.getCategory().getId());
		if (category == null) {
			Category categoryNew = new Category(0,productDto.getCategory().getCategory());
			this.categoryRepository.save(categoryNew);
			Product product = new Product(productDto.getId(),categoryNew,productDto.getName(),productDto.getPrice());
			this.productRepository.save(product);
		} else {
			Product product = new Product(productDto.getId(),category,productDto.getName(),productDto.getPrice());
			this.productRepository.save(product);
		}

	}

	public boolean putProduct(String id, ProductDto productDto) {
		Product product = this.productRepository.findOne(productDto.getId());
		assert product != null;
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		Category category = this.categoryRepository.findById(productDto.getCategory().getId());
		assert category != null;
		product.setCategory(category);
		return true;
	}

	public List<ProductDto> readAllProducts() {
		List<Product> productList = this.productRepository.findAll();
		List<ProductDto> productDtoList = new ArrayList<ProductDto>();
		for (Product product : productList) {
			productDtoList.add(new ProductDto(product));

		}
		return productDtoList;
	}

	public Optional<ProductDto> readProductsById(String id) {
		Product product = this.productRepository.findOne(id);
		if (product == null) {
			return Optional.empty();
		} else {
			return Optional.of(new ProductDto(product));
		}
	}

}
