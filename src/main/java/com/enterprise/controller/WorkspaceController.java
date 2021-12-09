package com.enterprise.controller;

import com.enterprise.config.GetParamtersToken;
import com.enterprise.entities.enterprise.Workspace;
import com.enterprise.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {
    @Autowired
    private WorkspaceService workspaceService;


    @GetMapping("/all")
    public List<Workspace> getParameter(){
        return workspaceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workspace> FindOne(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(workspaceService.getById(id).orElseThrow(() -> new NoSuchElementException("Workspace not found\n")));
    }
    @PostMapping
    public ResponseEntity<Object> createdWorkspace(@RequestBody Workspace workspace, @RequestHeader(value ="authorization") String token){
        System.out.println(GetParamtersToken.getparameterAdmin(token));
        if(GetParamtersToken.getparameterAdmin(token)) {
            return ResponseEntity.ok(workspaceService.createWorkspace(workspace));
        }
        else{
            return ResponseEntity.ok("You dont have privileges");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWorkspace(@PathVariable("id") Long id,@RequestBody Workspace workspace, @RequestHeader(value ="authorization") String token){
        System.out.println(GetParamtersToken.getparameterAdmin(token));
        if(GetParamtersToken.getparameterAdmin(token)) {
            return ResponseEntity.ok(workspaceService.updateWorkspace(id, workspace));
        }
        else{
            return ResponseEntity.ok("You dont have privileges");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedParameter(@PathVariable("id") Long id){
        return ResponseEntity.ok(workspaceService.deleteWorkspace(id));
    }
}
