package hu.haricsigak.csigareceptek.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(value = "id") Long id) {
        if (userService.getUser(id).isEmpty()) throw new ResponseStatusException(NOT_FOUND, "Unable to find user");
        return userService.getUser(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(value = "id") Long id) {
        if (!userService.deleteUser(id)) throw new ResponseStatusException(NOT_FOUND, "Unable to find user");
    }


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        if (!userService.addUser(user.getName(), user.getPassword()))
            throw new ResponseStatusException(CONFLICT, "Username already taken");
    }

    @PutMapping("/{id}")
    public void addUser(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String password
            ) {
        userService.updateUser(id, name, password);
    }

}
