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
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String Tag;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", Tag='" + Tag + '\'' +
                '}';
    }
}
