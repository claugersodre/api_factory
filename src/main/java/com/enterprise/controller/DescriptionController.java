package com.enterprise.controller;

import com.enterprise.entities.apiEntity.Description;
import com.enterprise.entities.enterprise.Enterprise;
import com.enterprise.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/description")
public class DescriptionController {
    @Autowired
    private DescriptionService descriptionService;

    //Description
    @GetMapping("/all")
    public List<Description> getDescription(){
        return descriptionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Description> FindOne(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(descriptionService.getById(id).orElseThrow(() -> new NoSuchElementException("Enterprise not found")));
    }
    @PostMapping
    public Description createDescription(@RequestBody Description description){
        return descriptionService.createdDescription(description);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedescription(@PathVariable("id") Long id){
        return ResponseEntity.ok(descriptionService.deleteDescription(id));
    }
}
