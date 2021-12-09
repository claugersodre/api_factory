package com.enterprise.controller;


import com.enterprise.EnterpriseAppliation;
import com.enterprise.config.GetParamtersToken;
import com.enterprise.entities.enterprise.User;
import com.enterprise.hash.Hash;
import com.enterprise.service.UserService;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService UserService;


    @GetMapping("/all")
    public List<User> getParameter(@RequestHeader(value ="authorization") String token){

        System.out.println(GetParamtersToken.getparameterAdmin(token));

        return UserService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> FindOne(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(UserService.getById(id).orElseThrow(() -> new NoSuchElementException("User not found\n")));
    }
    @PostMapping
    public ResponseEntity<Object> createdUser(@RequestBody User user, @RequestHeader(value ="authorization") String token) throws NoSuchAlgorithmException, NoSuchProviderException {
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
            return ResponseEntity.ok(UserService.createUser(user));
        }
        else{
            return ResponseEntity.ok("You dont have privileges");
        }
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
