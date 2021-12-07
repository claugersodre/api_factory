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

    public Optional<Description> getById(Long idJornada) {
        return descriptionRepository.findById(idJornada);
    }

    public Description createdDescription(Description Description){
        return descriptionRepository.save(Description);
    }
    public String deleteDescription(Long id) {

        if (descriptionRepository.findById(id).isPresent()) {
            descriptionRepository.deleteById(id);
            if (descriptionRepository.findById(id).isEmpty()) {
                return id + "is correct deleted";
            } else {
                return "Failed to delete: " + id;
            }

        }
        else{
            return id+ " Not exist";
        }
    }

}
