package com.rafael.falconi.products.resources.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN )
public class LoginException  extends Exception{

    private static final long serialVersionUID = -7717691994704695707L;

    public static final String DESCRIPTION = "datos incorectos";

    public LoginException() {
        super(DESCRIPTION);
    }
}
