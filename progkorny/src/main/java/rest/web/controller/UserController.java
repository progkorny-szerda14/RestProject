package rest.web.controller;

import rest.entity.User;
import rest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        log.info("process=get-users");
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        log.info("process=get-user, user_id={}", id);
        Optional<User> user = userService.getUserById(id);
        return user.map( u -> ResponseEntity.ok(u))
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/users")
    @ResponseStatus(CREATED)
    public User createUser(@RequestBody User user) {
        log.info("process=create-user, user_email={}", user.getEmail());
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        log.info("process=update-user, user_id={}", id);
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("process=delete-user, user_id={}", id);
        userService.deleteUser(id);
    }

    @GetMapping("/szm")
    public User getUser() {
        log.info("process=get-users");

        return new User("Szabó Máté", "szabo.mate@inf.unideb.hu", LocalDateTime.now() , LocalDateTime.now());
    }

    @GetMapping("/szs")
    public User getUser() {
        log.info("process=get-users");

        return new User("Szabó Sándor", "sanyi002@gmail.com", LocalDateTime.now() , LocalDateTime.now());
    }

    @GetMapping("/ka")
    public User getNameAttila() {
        log.info("process=get-users");

        return new User("Kozma Attila", "atikozma@gmail.com", LocalDateTime.now() , LocalDateTime.now());
    }

    @GetMapping("/message")
    public String getMessage(){
        System.out.println("14:42 + 14:47");
        return "Szabó Máté" + ", Szabó Sándor";
    }

}
