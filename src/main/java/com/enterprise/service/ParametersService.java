package com.enterprise.service;


import com.enterprise.entities.apiEntity.Parameters;

import com.enterprise.repository.ParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ParametersService {
    private final ParametersRepository parametersRepository;
    @Autowired
    public ParametersService(ParametersRepository parametersRepository){this.parametersRepository=parametersRepository;}
    public List<Parameters> findAll(){
        return parametersRepository.findAll();
    }

    public Optional<Parameters> getById(Long id) {
        return parametersRepository.findById(id);
    }

    public Parameters createParameters(Parameters parameters){
        return parametersRepository.save(parameters);
    }
    public Object updateParameters(Long id, Parameters parameters){
        if(parametersRepository.findById(id).isPresent() && (parameters.getId() == id) ){
            return parametersRepository.save(parameters);
        }
        else if (parametersRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }

    public String deleteParameter(Long id) {

        if (parametersRepository.findById(id).isPresent()) {
            parametersRepository.deleteById(id);
            if (parametersRepository.findById(id).isEmpty()) {
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
