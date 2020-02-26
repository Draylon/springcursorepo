package com.stonks.SpringComp.entities;

import com.stonks.SpringComp.enums.UserTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NOME",nullable = false)
    private String name;
    @Column(name = "TELEFONE",nullable = false)
    private String phone;
    @Column(name = "EMAIL",nullable = false)
    private String email;
    @Column(name = "SENHA",nullable = false)
    private String pword;
    @Column(name = "ENDERECO",nullable = false)
    private String address;
    @Column(name = "TIPO_USUARIO",nullable = false)
    private UserTypeEnum userType;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPword() {
        return pword;
    }

    public User setPword(String pword) {
        this.pword = pword;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public User setUserType(UserTypeEnum userType) {
        this.userType = userType;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", pword='" + pword + '\'' +
                ", address='" + address + '\'' +
                ", userType=" + userType +
                '}';
    }
}
