package com.enterprise.controller;

import com.enterprise.entities.apiEntity.Tag;
import com.enterprise.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Tag")
public class TagController {
    @Autowired
    private TagService tagService;


    @GetMapping("/all")
    public List<Tag> getParameter(){
        return tagService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> FindOne(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(tagService.getById(id).orElseThrow(() -> new NoSuchElementException("Tag not found\n")));
    }
    @PostMapping
    public Tag createdTag(@RequestBody Tag tag){
        return tagService.createTag(tag);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTag(@PathVariable("id") Long id,@RequestBody Tag tag){
        return ResponseEntity.ok(tagService.updateTag(id, tag));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedParameter(@PathVariable("id") Long id){
        return ResponseEntity.ok(tagService.deleteTag(id));
    }
}
