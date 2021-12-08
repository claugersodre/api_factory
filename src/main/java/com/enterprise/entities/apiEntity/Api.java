package com.enterprise.entities.apiEntity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(nullable = false)
//    private String path;
//
//    @Column(nullable = false)
//    private String method;


    @OneToMany(fetch = FetchType.LAZY)
    private Set<Description> description;


    @OneToMany(fetch = FetchType.LAZY)
    private Set<Parameters> parameters;


    @Override
    public String toString() {
        return "Api{" +
                "id=" + id +
                ", description=" + description +
                ", parameters=" + parameters +
                '}';
    }
}
/*
paths:{
    description{
    }
    parameters[{

        Ref{
        }
        Tag{
        }
    ]}
}

 */

// "paths": {
//         "/athletes/{id}/stats": {
//         "get": {
//         "operationId": "getStats",
//         "summary": "Get Athlete Stats",
//         "description": "Returns the activity stats of an athlete.",
//         "parameters": [
//         {
//         "name": "id",
//         "in": "path",
//         "description": "The identifier of the athlete. Must match the authenticated athlete.",
//         "required": true,
//         "type": "integer"
//         },
//         {
//         "$ref": "#/parameters/page"
//         },
//         {
//         "$ref": "#/parameters/perPage"
//         }
//         ],
//         "tags": [
//         "Athletes"
//         ],