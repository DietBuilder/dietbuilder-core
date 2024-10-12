package com.dietbuilder.domain.exceptions;

import java.util.NoSuchElementException;

public class RecipeNotFoundException extends NoSuchElementException {
    public RecipeNotFoundException(String s) {
        super(s);
    }
}
