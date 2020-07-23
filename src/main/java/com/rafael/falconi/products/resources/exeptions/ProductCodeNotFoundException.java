package com.rafael.falconi.products.resources.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductCodeNotFoundException extends Exception {
	private static final long serialVersionUID = -7717691994704695707L;

	public static final String DESCRIPTION = "product id not found";

	public ProductCodeNotFoundException() {
		super(DESCRIPTION);
	}

	public ProductCodeNotFoundException(String details) {
		super(DESCRIPTION + "." + details);
	}
}