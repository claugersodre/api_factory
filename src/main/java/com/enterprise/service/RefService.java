package com.enterprise.service;


import com.enterprise.entities.apiEntity.Parameters;
import com.enterprise.entities.apiEntity.Ref;
import com.enterprise.repository.RefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefService {
    private final RefRepository refRepository;
    @Autowired
    public RefService(RefRepository refRepository){this.refRepository=refRepository;}

    public List<Ref> findAll(){
        return refRepository.findAll();
    }

    public Optional<Ref> getById(Long id) {
        return refRepository.findById(id);
    }

    public Ref createRef(Ref ref){
        return refRepository.save(ref);
    }
    public Object refParameters(Long id, Ref ref){
        if(refRepository.findById(id).isPresent() && (ref.getId() == id) ){
            return refRepository.save(ref);
        }
        else{
            return "Id: "+id+ " is diferent form body";
        }
    }
    public String deleteRef(Long id) {

        if (refRepository.findById(id).isPresent()) {
            refRepository.deleteById(id);
            if (refRepository.findById(id).isEmpty()) {
                return "Id: "+id + " is correct deleted";
            } else {
                return "Failed to delete: " + id;
            }

        }
        else{
            return "Id: "+id+ " Not exist";
        }
    }
    public Object updateRef(Long id, Ref ref){
        if(refRepository.findById(id).isPresent() && (ref.getId() == id) ){
            return refRepository.save(ref);
        }
        else if (refRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }
}
