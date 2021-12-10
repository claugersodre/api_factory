package com.enterprise.service;


import com.enterprise.entities.enterprise.UserApi;
import com.enterprise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository UserRepository;
    @Autowired
    public UserService(UserRepository UserRepository){this.UserRepository=UserRepository;}

    public List<UserApi> findAll(){
        return UserRepository.findAll();
    }

    public Optional<UserApi> getById(Long id) {
        return UserRepository.findById(id);
    }

    public UserApi createUser(UserApi User){
        return UserRepository.save(User);
    }
    public Object UserParameters(Long id, UserApi User){
        if(UserRepository.findById(id).isPresent() && (User.getId() == id) ){
            return UserRepository.save(User);
        }
        else{
            return "Id: "+id+ " is diferent form body";
        }
    }
    public String deleteUser(Long id) {

        if (UserRepository.findById(id).isPresent()) {
            UserRepository.deleteById(id);
            if (UserRepository.findById(id).isEmpty()) {
                return "Id: "+id + " is correct deleted";
            } else {
                return "Failed to delete: " + id;
            }

        }
        else{
            return "Id: "+id+ " Not exist";
        }
    }
    public Object updateUser(Long id, UserApi User){
        if(UserRepository.findById(id).isPresent() && (User.getId() == id) ){
            return UserRepository.save(User);
        }
        else if (UserRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }

    public List<UserApi> getUserByName(String name){
        List<UserApi> listAll = UserRepository.findAll();
        System.out.println(listAll);
        List<UserApi> found =  listAll.stream().filter(x->x.getUsername().equals(name)).collect(Collectors.toList());
        found.stream().forEach(System.out::println);

            return found;

    }
}
