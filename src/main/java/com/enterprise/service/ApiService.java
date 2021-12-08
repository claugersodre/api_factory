package com.enterprise.service;


import com.enterprise.entities.apiEntity.Api;
import com.enterprise.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    private final ApiRepository apiRepository;
    @Autowired
    public ApiService(ApiRepository apiRepository){this.apiRepository=apiRepository;}

    public List<Api> findAll(){
        return apiRepository.findAll();
    }

    public Optional<Api> getById(Long id) {
        return apiRepository.findById(id);
    }

    public Api createApi(Api api){
        return apiRepository.save(api);
    }

    public String deleteApi(Long id) {

        if (apiRepository.findById(id).isPresent()) {
            apiRepository.deleteById(id);
            if (apiRepository.findById(id).isEmpty()) {
                return "Id: "+id + " is correct deleted";
            } else {
                return "Failed to delete: " + id;
            }

        }
        else{
            return "Id: "+id+ " Not exist";
        }
    }
    public Object updateApi(Long id, Api api){
        if(apiRepository.findById(id).isPresent() && (api.getId() == id) ){
            return apiRepository.save(api);
        }
        else if (apiRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }
}
