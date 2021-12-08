package com.enterprise.service;


import com.enterprise.entities.apiEntity.Tag;
import com.enterprise.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;
    @Autowired
    public TagService(TagRepository tagRepository){this.tagRepository=tagRepository;}

    public List<Tag> findAll(){
        return tagRepository.findAll();
    }

    public Optional<Tag> getById(Long id) {
        return tagRepository.findById(id);
    }

    public Tag createTag(Tag tag){
        return tagRepository.save(tag);
    }
    public Object tagParameters(Long id, Tag tag){
        if(tagRepository.findById(id).isPresent() && (tag.getId() == id) ){
            return tagRepository.save(tag);
        }
        else{
            return "Id: "+id+ " is diferent form body";
        }
    }
    public String deleteTag(Long id) {

        if (tagRepository.findById(id).isPresent()) {
            tagRepository.deleteById(id);
            if (tagRepository.findById(id).isEmpty()) {
                return "Id: "+id + " is correct deleted";
            } else {
                return "Failed to delete: " + id;
            }

        }
        else{
            return "Id: "+id+ " Not exist";
        }
    }
    public Object updateTag(Long id, Tag tag){
        if(tagRepository.findById(id).isPresent() && (tag.getId() == id) ){
            return tagRepository.save(tag);
        }
        else if (tagRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }
}
