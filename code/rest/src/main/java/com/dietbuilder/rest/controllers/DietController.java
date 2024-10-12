package com.dietbuilder.rest.controllers;

import com.dietbuilder.api.DietsApi;
import com.dietbuilder.rest.mappers.DietDtoDietModelMapper;
import com.dietbuilder.domain.daos.DietDao;
import com.dietbuilder.domain.exceptions.DietNotFoundException;
import com.dietbuilder.model.DietDto;
import com.dietbuilder.domain.model.diet.Diet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@Slf4j
public class DietController implements DietsApi {

    @Autowired
    private DietDao dietDao;

    @Autowired
    private DietDtoDietModelMapper mapper;

    @Override
    public ResponseEntity<DietDto> findDietByDietId(Long dietId) {
        Diet diet;

        try {
            diet = dietDao.findDietByDietId(dietId);
        } catch (DietNotFoundException e) {
            log.error("Diet with this ID does not exist.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(mapper.destinationToSource(diet));
    }

    @Override
    public ResponseEntity<DietDto> findDietByUserId(Long userId) {
        Diet diet;

        try {
            diet = dietDao.findDietByUserId(userId);
        } catch (NoSuchElementException e) {
            log.error("Could not find record: ", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(mapper.destinationToSource(diet));
    }

}
