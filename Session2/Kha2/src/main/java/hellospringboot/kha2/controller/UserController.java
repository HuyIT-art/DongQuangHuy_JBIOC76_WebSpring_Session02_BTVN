package hellospringboot.kha2.controller;


import hellospringboot.kha2.model.User;
import hellospringboot.kha2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(
            @RequestParam(required = false) String search
    ) {

        List<User> users = userService.findAllUsers();

        // Nếu có search thì lọc theo username
        if (search != null && !search.isEmpty()) {
            users = users.stream()
                    .filter(user ->
                            user.getUsername()
                                    .toLowerCase()
                                    .contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return ResponseEntity.ok(users);
    }
}