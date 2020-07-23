package com.rafael.falconi.products.dtos;

import com.rafael.falconi.products.documents.Category;

public class CategoryDto {
	private String id;

	private String category;

	public CategoryDto(){
	}

	public CategoryDto(String id, String category) {
		this.id = id;
		this.category = category;
	}

	public CategoryDto(Category category){
		this.id=category.getId();
		this.category=category.getCategory();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
