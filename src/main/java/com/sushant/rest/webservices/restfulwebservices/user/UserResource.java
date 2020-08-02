package com.sushant.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    UserDaoService userDao;

    @GetMapping(path = "/users")
    public List<User> retriveAllUsers ( ) {
        return userDao.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retriveUser (@PathVariable int id) {
        return userDao.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser (@RequestBody User user) {
        User savedUser = userDao.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
