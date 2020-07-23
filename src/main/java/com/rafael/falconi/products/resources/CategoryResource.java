package com.rafael.falconi.products.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.falconi.products.controllers.CategoryController;
import com.rafael.falconi.products.dtos.CategoryDto;
import com.rafael.falconi.products.resources.exeptions.CategoryCodeNotFoundException;
import com.rafael.falconi.products.resources.exeptions.CategoryFieldAlreadyExistException;

@RestController
@RequestMapping(CategoryResource.CATEGORIES)
public class CategoryResource {

	public static final String CATEGORIES = "/categories";

	public static final String ID = "/{id}";

	@Autowired
	private CategoryController categoryController;

	@RequestMapping(value = ID, method = RequestMethod.GET)
	public CategoryDto readCategory(@PathVariable String id) throws CategoryCodeNotFoundException {
		return this.categoryController.readCategory(id).orElseThrow(() -> new CategoryCodeNotFoundException(id));

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CategoryDto> readCategoryAll() {
		return this.categoryController.readCategoryAll();
	}

	@PostMapping
	public void createCategory(@Valid @RequestBody CategoryDto categoryDto) throws CategoryFieldAlreadyExistException {
		this.categoryController.createCategory(categoryDto);
	}

	@PutMapping(value = ID)
	public void putCategory(@PathVariable String id, @Valid @RequestBody CategoryDto categoryDto)
			throws CategoryCodeNotFoundException {
		if (!this.categoryController.putCategory(id, categoryDto)) {
			throw new CategoryCodeNotFoundException();
		}
	}

}
