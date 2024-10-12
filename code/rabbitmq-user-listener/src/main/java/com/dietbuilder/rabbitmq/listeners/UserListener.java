package com.dietbuilder.rabbitmq.listeners;

import com.dietbuilder.rabbitmq.mappers.UserQueueModelToUserModelMapper;
import com.dietbuilder.rabbitmq.model.User;
import com.dietbuilder.core.services.DietService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserListener {

    private final DietService dietService;

    private final UserQueueModelToUserModelMapper mapper;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveUser(User user) {
        log.info("Starting processing user with id: " + user.getId());
        dietService.createDiet(mapper.sourceToDestination(user));
    }
}
