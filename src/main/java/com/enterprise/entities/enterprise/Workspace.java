package com.enterprise.entities.enterprise;

import com.enterprise.entities.apiEntity.Api;
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
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Override
    public String toString() {
        return "Workspace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", api=" + api +
                '}';
    }

    @Column(nullable = false)
    private String name;


    @OneToMany(fetch = FetchType.LAZY)
    private Set<UserApi> user;


    @OneToMany(fetch = FetchType.LAZY)
    private Set<Api> api;
}
