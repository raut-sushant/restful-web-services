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

    @GetMapping("/users")
    public List<User> retriveAllUsers ( ) {
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveUser (@PathVariable int id) {
        User user = userDao.findOne(id);

        if(user == null){
            throw new UserNotFoundException("Id - " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser (@RequestBody User user) {
        User savedUser = userDao.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser (@PathVariable int id){
        User deletedUser = userDao.deleteById(id);
        if(deletedUser == null){
            throw new UserNotFoundException("id - " + deletedUser.getId());
        }
    }
}
