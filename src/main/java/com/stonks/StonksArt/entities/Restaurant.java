package com.stonks.StonksArt.entities;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANTE")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NOME", nullable = false)
    private String name;
    @Column(name = "CNPJ", nullable = false)
    private String cnpj;
    @Column(name = "TELEFONE",nullable = false)
    private String telefone;
    @Column(name = "EMAIL",nullable = false)
    private String email;

    public Integer getId() {
        return id;
    }

    public Restaurant setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Restaurant setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Restaurant setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Restaurant setEmail(String email) {
        this.email = email;
        return this;
    }
}
