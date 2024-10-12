package com.dietbuilder.domain.exceptions;

import java.util.NoSuchElementException;

public class DietNotFoundException extends NoSuchElementException {
    public DietNotFoundException(String s) {
        super(s);
    }
}
