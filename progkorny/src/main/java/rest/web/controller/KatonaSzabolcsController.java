package rest.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ksz")
@Slf4j
public class KatonaSzabolcsController {

    @GetMapping("")
    public User getUser() {
        log.info("process=get-users");

        return new User("Katona Szabolcs", "szabolcs.katona23@gmail.com", LocalDateTime.now() , LocalDateTime.now());
    }
}
