package com.enterprise.service;


import com.enterprise.entities.enterprise.User;
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

    public List<User> findAll(){
        return UserRepository.findAll();
    }

    public Optional<User> getById(Long id) {
        return UserRepository.findById(id);
    }

    public User createUser(User User){
        return UserRepository.save(User);
    }
    public Object UserParameters(Long id, User User){
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
    public Object updateUser(Long id, User User){
        if(UserRepository.findById(id).isPresent() && (User.getId() == id) ){
            return UserRepository.save(User);
        }
        else if (UserRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }

    public List<User> getUserByName(String name){
        List<User> listAll = UserRepository.findAll();
        List<User> found =  listAll.stream().filter(x->x.getUsername().equals(name)).collect(Collectors.toList());
        found.stream().forEach(System.out::println);

            return found;

    }
}
