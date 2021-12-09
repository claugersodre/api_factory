package com.enterprise.controller;

import com.enterprise.entities.enterprise.Enterprise;
import com.enterprise.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;


    @GetMapping("/all")
    public List<Enterprise> getParameter(){
        return enterpriseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> FindOne(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(enterpriseService.getById(id).orElseThrow(() -> new NoSuchElementException("Enterprise not found\n")));
    }
    @PostMapping
    public Enterprise createdEnterprise(@RequestBody Enterprise enterprise){
        return enterpriseService.createEnterprise(enterprise);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEnterprise(@PathVariable("id") Long id,@RequestBody Enterprise enterprise){
        return ResponseEntity.ok(enterpriseService.updateEnterprise(id, enterprise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedParameter(@PathVariable("id") Long id){
        return ResponseEntity.ok(enterpriseService.deleteEnterprise(id));
    }
}
