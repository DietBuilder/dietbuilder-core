package com.dietbuilder.rest.controllers;

import com.dietbuilder.api.InitApi;
import com.dietbuilder.core.services.InitializeDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitializeDatabaseController implements InitApi {

    @Autowired
    private InitializeDatabaseService initializeDatabaseService;

    public ResponseEntity<Void> initDatabase() {
        initializeDatabaseService.dropDatabase();
        initializeDatabaseService.initializeComestibleProducts();
        initializeDatabaseService.initializeMeals();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
