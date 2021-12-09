package com.enterprise.controller;


import com.enterprise.entities.enterprise.User;
import com.enterprise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService UserService;


    @GetMapping("/all")
    public List<User> getParameter(){
        return UserService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> FindOne(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(UserService.getById(id).orElseThrow(() -> new NoSuchElementException("User not found\n")));
    }
    @PostMapping
    public User createdUser(@RequestBody User User){
        return UserService.createUser(User);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") Long id,@RequestBody User User){
        return ResponseEntity.ok(UserService.updateUser(id, User));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedParameter(@PathVariable("id") Long id){
        return ResponseEntity.ok(UserService.deleteUser(id));
    }
}
