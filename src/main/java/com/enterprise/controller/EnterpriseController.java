package com.enterprise.controller;

import com.enterprise.entities.apiEntity.Description;
import com.enterprise.entities.enterprise.Enterprise;
import com.enterprise.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.enterprise.service.EnterpriseService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/enterprise")
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;


    @GetMapping("/all")
    public List<Enterprise> GetEnterprise(){
        return enterpriseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> FindOne(@PathVariable("id") Long id) throws Exception{
       return ResponseEntity.ok(enterpriseService.getById(id).orElseThrow(() -> new NoSuchElementException("Enterprise not found")));
    }
    @PostMapping
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise){
        return enterpriseService.createdEnterprise(enterprise);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnterprise(@PathVariable("id") Long id){
        return ResponseEntity.ok(enterpriseService.deleteEnterprise(id));
    }


}
