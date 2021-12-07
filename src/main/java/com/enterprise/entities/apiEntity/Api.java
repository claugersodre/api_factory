package com.enterprise.entities.apiEntity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String method;


    @ManyToOne(fetch = FetchType.LAZY)
    private Description description;


    @ManyToOne(fetch = FetchType.LAZY)
    private Parameters parameters;


    @ManyToOne(fetch = FetchType.LAZY)
    private Tag tags;


    @ManyToOne(fetch = FetchType.LAZY)
    private Ref ref;

    @Override
    public String toString() {
        return "Api{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", method='" + method + '\'' +
                ", description=" + description +
                ", parameters=" + parameters +
                ", tags=" + tags +
                '}';
    }
}
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