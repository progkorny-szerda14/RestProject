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
    public User getUserSzS() {
        log.info("process=get-users");
        return new User("Szabó Sándor", "sanyi002@gmail.com", LocalDateTime.now() , LocalDateTime.now());
    }

    @GetMapping("/message")
    public String getMessage(){
        try {
            System.out.println("14:42 + 14:47");
            return "vajon mit ad vissza?";
        }
        catch (Exception ex){
            System.out.println("baj van :P");
        }
        finally {
            System.out.println("14:42");
            System.out.println("14:51");
            System.out.println("14:42 + 14:47");
            System.out.println("14:57");
            System.out.println("15:05");
            return "Szabó Máté" + ", Szabó Sándor"+ "15:05";
        }
    }
	
	@GetMapping("/csa")
    public User getCsaUser() {
        log.info("process=get-users");
        return new User("Csoltkó András", "andras.csoltko@gmail.com", LocalDateTime.now(), LocalDateTime.now());
    }

	@GetMapping("/mal")
    public User getMalUser() {
        log.info("process=get-users");
        return new User("Mohácsi Ádám László", "mohaa556@gmail.com", LocalDateTime.now(), LocalDateTime.now());
    }

    @GetMapping("/szilajka")
    public User getSzilajkaUser(){
        return new User("Németi Szilárd", "szilajka1@gmail.com", LocalDateTime.now(), LocalDateTime.now());
    }

}
