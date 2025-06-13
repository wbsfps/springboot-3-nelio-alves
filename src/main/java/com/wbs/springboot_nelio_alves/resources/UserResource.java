package com.wbs.springboot_nelio_alves.resources;

import com.wbs.springboot_nelio_alves.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        var user = new User(1, "William", "williamandrade1058@gmail.com", "79 99916-5932", "311204");
        return ResponseEntity.ok().body(user);
    }
}
