package x.longrunningapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import x.longrunningapi.services.UserService;
import x.longrunningapi.models.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public CompletableFuture<ResponseEntity<List<User>>> getUser() {
        return userService.getUsers()
                .thenApply(ResponseEntity::ok);
    }
}