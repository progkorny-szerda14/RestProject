package rest.web.controller;

import lombok.extern.slf4j.Slf4j;
import rest.entity.User;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/szilajka")
@Slf4j
public class NemetiSzilardController {
    @GetMapping("")
    public User getUser(){
        //log.info("process=get-user");

        return new User("Németi Szilárd", "szilajka1@gmail.com", LocalDateTime.now(), LocalDateTime.now());
    }
}
