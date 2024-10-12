package com.dietbuilder.rest.error.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
abstract class ErrorResponseModel {
    protected final String title;
    protected final String detailedMessage;
}
