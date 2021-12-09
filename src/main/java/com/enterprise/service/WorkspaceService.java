package com.enterprise.service;


import com.enterprise.entities.enterprise.Workspace;
import com.enterprise.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkspaceService {
    private final WorkspaceRepository WorkspaceRepository;
    @Autowired
    public WorkspaceService(WorkspaceRepository WorkspaceRepository){this.WorkspaceRepository=WorkspaceRepository;}

    public List<Workspace> findAll(){
        return WorkspaceRepository.findAll();
    }

    public Optional<Workspace> getById(Long id) {
        return WorkspaceRepository.findById(id);
    }

    public Workspace createWorkspace(Workspace Workspace){
        return WorkspaceRepository.save(Workspace);
    }
    public Object WorkspaceParameters(Long id, Workspace Workspace){
        if(WorkspaceRepository.findById(id).isPresent() && (Workspace.getId() == id) ){
            return WorkspaceRepository.save(Workspace);
        }
        else{
            return "Id: "+id+ " is diferent form body";
        }
    }
    public String deleteWorkspace(Long id) {

        if (WorkspaceRepository.findById(id).isPresent()) {
            WorkspaceRepository.deleteById(id);
            if (WorkspaceRepository.findById(id).isEmpty()) {
                return "Id: "+id + " is correct deleted";
            } else {
                return "Failed to delete: " + id;
            }

        }
        else{
            return "Id: "+id+ " Not exist";
        }
    }
    public Object updateWorkspace(Long id, Workspace Workspace){
        if(WorkspaceRepository.findById(id).isPresent() && (Workspace.getId() == id) ){
            return WorkspaceRepository.save(Workspace);
        }
        else if (WorkspaceRepository.findById(id).isPresent()){
            return "Id: "+id+ " is different form body";
        }
        else
            return "Id: "+id+ " Not exist";
    }

    public List<Workspace> getWorkspaceByName(String name){
        List<Workspace> listAll = WorkspaceRepository.findAll();
        System.out.println(listAll);
        List<Workspace> found =  listAll.stream().filter(x->x.getName().equals(name)).collect(Collectors.toList());
        found.stream().forEach(System.out::println);

            return found;

    }
}
