package rest.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/kk")
@Slf4j
public class KovacsKristofController {

    @GetMapping("")
    public User getUser() {
        log.info("process=get-users");

        return new User("Kovács Kristóf", "kristofkovacs25@gmail.com", LocalDateTime.now() , LocalDateTime.now());
    }
}
