package com.enterprise.controller;


import com.enterprise.config.GetParamtersToken;
import com.enterprise.entities.enterprise.UserApi;

import com.enterprise.hash.Hash;

import com.enterprise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public List<UserApi> getParameter(@RequestHeader(value ="authorization") String token){

        System.out.println(GetParamtersToken.getparameterAdmin(token));

        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserApi> FindOne(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(userService.getById(id).orElseThrow(() -> new NoSuchElementException("User not found\n")));
    }
    @PostMapping
    public ResponseEntity<Object> createdUser(@RequestBody UserApi user, @RequestHeader(value ="authorization") String token) throws NoSuchAlgorithmException, NoSuchProviderException {
        System.out.println(GetParamtersToken.getparameterAdmin(token));
        if(GetParamtersToken.getparameterAdmin(token)) {
            String passwordToHash = user.getPassword();
            String salt = Hash.getSalt();

            String securePassword = Hash.getSecurePassword(passwordToHash);

            //System.out.println("Novo password "+securePassword);

//        String regeneratedPassowrdToVerify = Hash.getSecurePassword(passwordToHash, salt);
//
//        System.out.println(regeneratedPassowrdToVerify);

            user.setPassword(securePassword);
            return ResponseEntity.ok(userService.createUser(user));
        }
        else{
            return ResponseEntity.ok("You dont have privileges");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") Long id,@RequestBody UserApi User){
        return ResponseEntity.ok(userService.updateUser(id, User));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedParameter(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
