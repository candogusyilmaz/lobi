package dev.canverse.server.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter

public class User {
    @Id
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}
