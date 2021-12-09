package com.enterprise.controller;

import com.enterprise.entities.apiEntity.Api;
import com.enterprise.service.ApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ApiService apiService;


    @GetMapping("/all")
    public List<Api> getApi() {
        return apiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Api> FindOne(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(apiService.getById(id).orElseThrow(() -> new NoSuchElementException("Api not found\n")));
    }

    @PostMapping
    public Api createdApi(@RequestBody Api api) {
        return apiService.createApi(api);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateApi(@PathVariable("id") Long id, @RequestBody Api api) {
        return ResponseEntity.ok(apiService.updateApi(id, api));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedApi(@PathVariable("id") Long id) {
        return ResponseEntity.ok(apiService.deleteApi(id));
    }

    @GetMapping("/pretty/{id}")
    public ResponseEntity<Object> FindOnePretty(@PathVariable("id") Long id) throws Exception {
//        DtoApi paths = new DtoApi();
        Api apiResponse = apiService.getById(id).orElseThrow(() -> new NoSuchElementException("Api not found\n"));
        if (apiResponse.getDescription().isEmpty()) {
           return ResponseEntity.ok("Api not found");
        } else {
//            Set<Description> descriptionSet =apiResponse.getDescription();
//            Set<Parameters> parametersSet = apiResponse.getParameters();
//
//            paths.setDescriptionResume(descriptionSet.iterator().next().getDescriptionResume());
//            paths.setMethodDescription(descriptionSet.iterator().next().getMethod());
//            paths.setPathDescription(descriptionSet.iterator().next().getPath());
//            paths.setOperationIdDescritpion(descriptionSet.iterator().next().getOperationId());
//            paths.setSummaryDescription(descriptionSet.iterator().next().getSummary());
//
//            paths.setDescriptionParameter(parametersSet.iterator().next().getDescription());
//            paths.setInParameter(parametersSet.iterator().next().getIn());
//            paths.setNameParameter(parametersSet.iterator().next().getName());
//            paths.setRequireParameter(parametersSet.iterator().next().getRequire());
//            paths.setTypeParameter(parametersSet.iterator().next().getType());

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(apiResponse);

            System.out.println("Object Json "+json);
            return ResponseEntity.ok(json);
        }

    }

}
