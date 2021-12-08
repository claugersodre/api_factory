package com.enterprise.controller;

import com.enterprise.entities.apiEntity.Ref;
import com.enterprise.service.RefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Ref")
public class RefsController {
    @Autowired
    private RefService refService;


    @GetMapping("/all")
    public List<Ref> getParameter(){
        return refService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ref> FindOne(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(refService.getById(id).orElseThrow(() -> new NoSuchElementException("Ref not found\n")));
    }
    @PostMapping
    public Ref createdRef(@RequestBody Ref ref){
        return refService.createRef(ref);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRef(@PathVariable("id") Long id,@RequestBody Ref ref){
        return ResponseEntity.ok(refService.updateRef(id, ref));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedParameter(@PathVariable("id") Long id){
        return ResponseEntity.ok(refService.deleteRef(id));
    }
}
