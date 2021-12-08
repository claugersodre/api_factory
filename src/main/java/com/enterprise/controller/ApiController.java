package com.enterprise.controller;

import com.enterprise.entities.apiEntity.Api;
import com.enterprise.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Api")
public class ApiController {
    @Autowired
    private ApiService apiService;


    @GetMapping("/all")
    public List<Api> getApi() {
        return apiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Api> FindOne(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(apiService.getById(id).orElseThrow(() -> new NoSuchElementException("Api not found\n")));
    }

    @PostMapping
    public Api createdApi(@RequestBody Api api) {
        return apiService.createApi(api);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateApi(@PathVariable("id") Long id, @RequestBody Api api) {
        return ResponseEntity.ok(apiService.updateApi(id, api));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedApi(@PathVariable("id") Long id) {
        return ResponseEntity.ok(apiService.deleteApi(id));
    }

    @GetMapping("/pretty/{id}")
    public ResponseEntity<Object> FindOnePretty(@PathVariable("id") Long id) throws Exception {
        Object paths = "";
        Api apiResponse = apiService.getById(id).orElseThrow(() -> new NoSuchElementException("Api not found\n"));
        if (apiResponse.getDescription().isEmpty()) {
           return ResponseEntity.ok("Api not found");
        } else {

            return ResponseEntity.ok(paths);
        }

    }

}
