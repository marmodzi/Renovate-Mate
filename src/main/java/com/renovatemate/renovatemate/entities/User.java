package com.renovatemate.renovatemate.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[a-z])[a-zA-Z\\d]{8,}$", message = "Hasło musi zawierać co najmniej 8 znaków, w tym co najmniej dwie cyfry i jedną dużą literę.")
    private String password;

    private String email;

    // at this stage of application, not yet used

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
