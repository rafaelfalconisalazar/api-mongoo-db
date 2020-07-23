package com.rafael.falconi.products.resources.exeptions;

public class CategoryFieldAlreadyExistException extends Exception {
	private static final long serialVersionUID = -7717691994704695707L;
	public static final String DESCRIPTION = "Category Field Already Exist";

	public CategoryFieldAlreadyExistException() {
		super(DESCRIPTION);
	}

	public CategoryFieldAlreadyExistException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
