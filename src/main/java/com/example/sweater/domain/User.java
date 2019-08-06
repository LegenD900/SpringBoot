package com.example.sweater.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //автогенерирует id
    private Long id;

    private String UserName;

    private String Pass;

    private boolean Active;  // признак активности

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)  // EAGER жадная подгрузка
    @CollectionTable(name = "User_role", joinColumns = @JoinColumn(name = "User_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;     // роль пользователя

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
