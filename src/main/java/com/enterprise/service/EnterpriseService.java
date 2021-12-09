package com.enterprise.service;


import com.enterprise.entities.enterprise.Enterprise;
import com.enterprise.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnterpriseService {
    private final EnterpriseRepository EnterpriseRepository;
    @Autowired
    public EnterpriseService(EnterpriseRepository EnterpriseRepository){this.EnterpriseRepository=EnterpriseRepository;}

    public List<Enterprise> findAll(){
        return EnterpriseRepository.findAll();
    }

    public Optional<Enterprise> getById(Long id) {
        return EnterpriseRepository.findById(id);
    }

    public Enterprise createEnterprise(Enterprise Enterprise){
        return EnterpriseRepository.save(Enterprise);
    }
    public Object EnterpriseParameters(Long id, Enterprise Enterprise){
        if(EnterpriseRepository.findById(id).isPresent() && (Enterprise.getId() == id) ){
            return EnterpriseRepository.save(Enterprise);
        }
        else{
            return "Id: "+id+ " is diferent form body";
        }
    }
    public String deleteEnterprise(Long id) {

        if (EnterpriseRepository.findById(id).isPresent()) {
            EnterpriseRepository.deleteById(id);
            if (EnterpriseRepository.findById(id).isEmpty()) {
                return "Id: "+id + " is correct deleted";
            } else {
                return "Failed to delete: " + id;
            }

        }
        else{
            return "Id: "+id+ " Not exist";
        }
    }
    public Object updateEnterprise(Long id, Enterprise Enterprise){
        if(EnterpriseRepository.findById(id).isPresent() && (Enterprise.getId() == id) ){
            return EnterpriseRepository.save(Enterprise);
        }
        else if (EnterpriseRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }

    public List<Enterprise> getEnterpriseByName(String name){
        List<Enterprise> listAll = EnterpriseRepository.findAll();
        System.out.println(listAll);
        List<Enterprise> found =  listAll.stream().filter(x->x.getName().equals(name)).collect(Collectors.toList());
        found.stream().forEach(System.out::println);

            return found;

    }
}
