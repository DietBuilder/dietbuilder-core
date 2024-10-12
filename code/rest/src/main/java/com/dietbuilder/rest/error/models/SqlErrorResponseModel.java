package com.dietbuilder.rest.error.models;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SqlErrorResponseModel extends ErrorResponseModel {

    private final String sqlState;

    @Builder
    public SqlErrorResponseModel(String title, String detailedMessage, String sqlState) {
        super(title, detailedMessage);
        this.sqlState = sqlState;
    }
}
