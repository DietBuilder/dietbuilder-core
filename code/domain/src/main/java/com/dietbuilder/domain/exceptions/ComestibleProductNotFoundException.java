package com.dietbuilder.domain.exceptions;

import java.util.NoSuchElementException;

public class ComestibleProductNotFoundException extends NoSuchElementException {
    public ComestibleProductNotFoundException(String s) {
        super(s);
    }
}
