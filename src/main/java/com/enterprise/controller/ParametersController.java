package com.enterprise.controller;

import com.enterprise.entities.apiEntity.Parameters;
import com.enterprise.service.ParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Parameters")
public class ParametersController {
    @Autowired
    private ParametersService parametersService;


    @GetMapping("/all")
    public List<Parameters> getParameter(){
        return parametersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parameters> FindOne(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(parametersService.getById(id).orElseThrow(() -> new NoSuchElementException("Parameter not found\n")));
    }
    @PostMapping
    public Parameters createdParameter(@RequestBody Parameters parameters){
        return parametersService.createParameters(parameters);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParameter(@PathVariable("id") Long id,@RequestBody Parameters parameters){
        return ResponseEntity.ok(parametersService.updateParameters(id, parameters));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedParameter(@PathVariable("id") Long id){
        return ResponseEntity.ok(parametersService.deleteParameter(id));
    }
}
