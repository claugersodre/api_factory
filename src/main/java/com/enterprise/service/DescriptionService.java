package com.enterprise.service;

import com.enterprise.entities.apiEntity.Description;
import com.enterprise.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescriptionService {
    private final DescriptionRepository descriptionRepository;
    @Autowired
    public DescriptionService(DescriptionRepository descriptionRepository){this.descriptionRepository=descriptionRepository;}
    public List<Description> findAll(){
        return descriptionRepository.findAll();
    }

    public Optional<Description> getById(Long id) {
        return descriptionRepository.findById(id);
    }

    public Description createdDescription(Description Description){
        return descriptionRepository.save(Description);
    }
    public Object updateDescription(Long id, Description description){
        if(descriptionRepository.findById(id).isPresent() && (description.getId() == id) ){
            return descriptionRepository.save(description);
        }
        else if (descriptionRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }
    public String deleteDescription(Long id) {

        if (descriptionRepository.findById(id).isPresent()) {
            descriptionRepository.deleteById(id);
            if (descriptionRepository.findById(id).isEmpty()) {
                return "Id: "+id + " is correct deleted";
            } else {
                return "Failed to delete: " + id;
            }

        }
        else{
            return "Id: "+id+ " Not exist";
        }
    }

}
