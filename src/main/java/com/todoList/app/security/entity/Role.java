package com.todoList.app.security.entity;

import com.todoList.app.security.enums.RoleName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName rolNombre;

    public Role() {
    }

    public Role(@NotNull RoleName rolNombre) {
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleName getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RoleName rolNombre) {
        this.rolNombre = rolNombre;
    }
}
