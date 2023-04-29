package com.example.product_catalog_demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Column(name = "id")
    @Id
    @SequenceGenerator(name = "role_seq",
                       sequenceName = "role_sequence",
                       initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
