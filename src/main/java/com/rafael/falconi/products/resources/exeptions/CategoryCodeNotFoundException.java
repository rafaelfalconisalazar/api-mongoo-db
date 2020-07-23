package com.rafael.falconi.products.resources.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class CategoryCodeNotFoundException extends Exception {

	private static final long serialVersionUID = -7717691994704695707L;

	public static final String DESCRIPTION = "category id not found";

	public CategoryCodeNotFoundException() {
		super(DESCRIPTION);
	}

	public CategoryCodeNotFoundException(String details) {
		super(DESCRIPTION + "." + details);
	}

}
