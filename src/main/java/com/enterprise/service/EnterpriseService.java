package com.enterprise.service;

import com.enterprise.entities.apiEntity.Description;
import com.enterprise.entities.enterprise.Enterprise;
import com.enterprise.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;
    @Autowired
    public EnterpriseService(EnterpriseRepository enterpriseRepository){
        this.enterpriseRepository = enterpriseRepository;
    }

    public List<Enterprise> findAll(){
        return enterpriseRepository.findAll();
    }

    public Optional<Enterprise> getById(Long id) {
        return enterpriseRepository.findById(id);
    }

    public Enterprise createdEnterprise(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }
    public String deleteEnterprise(Long id) {

        if (enterpriseRepository.findById(id).isPresent()) {
            enterpriseRepository.deleteById(id);
            if (enterpriseRepository.findById(id).isEmpty()) {
                return id + " is correct deleted";
            } else {
                return "Failed to delete: " + id;
            }

        }
        else{
            return id+ " Not exist";
        }
    }
    public Object updateEnterprise(Long id, Enterprise enterprise){
        if(enterpriseRepository.findById(id).isPresent() && (enterprise.getId() == id) ){
            return enterpriseRepository.save(enterprise);
        }
        else if (enterpriseRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }

}
