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
public class Ref {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String refs;

    @Override
    public String toString() {
        return "Ref{" +
                "id=" + id +
                ", refs='" + refs + '\'' +
                '}';
    }
}
