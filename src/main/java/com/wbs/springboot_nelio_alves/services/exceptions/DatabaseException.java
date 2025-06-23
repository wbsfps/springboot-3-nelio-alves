package com.wbs.springboot_nelio_alves.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public DatabaseException(String message) {
        super(message);
    }
}
