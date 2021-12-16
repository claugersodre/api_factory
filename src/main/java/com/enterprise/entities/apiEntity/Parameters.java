package com.enterprise.entities.apiEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Parameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String in;
    @Column(nullable = false)
    private String Description;
    @Column(nullable = false)
    private String require;
    @Column(nullable = false)
    private String type;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Tag> tags;


    @OneToMany(fetch = FetchType.LAZY)
    private Set<Ref> ref;
}
