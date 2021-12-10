package com.enterprise.entities.enterprise;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userapi")
@EqualsAndHashCode
@Builder
@Entity
public class UserApi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Boolean admin;

    @Column(nullable = false)
    private String username;


    @Column(nullable = false)
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", admin=" + admin +
                ", name=" + username +
                ", password= '"+password+ '\'' +
                '}';
    }
}
