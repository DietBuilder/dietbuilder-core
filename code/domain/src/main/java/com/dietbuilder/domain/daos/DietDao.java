package com.dietbuilder.domain.daos;

import com.dietbuilder.domain.exceptions.DietNotFoundException;
import com.dietbuilder.domain.model.diet.Diet;
import com.dietbuilder.domain.repositories.DietRepository;
import com.dietbuilder.domain.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@Slf4j
public class DietDao {

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private UserDao userDao;



    public Diet findDietByDietId(Long id) {
        Optional<Diet> dietOptional = dietRepository.findById(id);

        if (dietOptional.isPresent()) {
            log.info("Diet has been found");
            return dietOptional.get();
        } else {
            throw new DietNotFoundException("Cannot find diet with id: " + id);
        }
    }

    public Diet findDietByUserId(Long id) {
        User user = userDao.getUserById(id);
        
        Long dietId = user.getDietId();

        Optional<Diet> dietOptional = null;
        
        if (Objects.nonNull(dietId)) {
            dietOptional = dietRepository.findById(dietId);
        }

        if (dietOptional.isPresent()) {
            log.info("Diet has been found");
            return dietOptional.get();
        } else {
            throw new DietNotFoundException("Cannot find diet with id: " + id);
        }
    }
}
