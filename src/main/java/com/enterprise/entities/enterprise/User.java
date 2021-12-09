package com.enterprise.entities.enterprise;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Boolean admin;

    @Column(nullable = false)
    private String username;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

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
