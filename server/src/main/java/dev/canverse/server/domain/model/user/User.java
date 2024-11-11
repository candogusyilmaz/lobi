package dev.canverse.server.domain.model.user;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;


/**
 * User from the authorization server that will be used to represent the user in the application.
 * OAuth2 will be used to authenticate the user.
 */
@Entity
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @Getter
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String username;

    @Getter
    private String email;

    @Getter
    private String firstName;

    @Getter
    private String lastName;
}
