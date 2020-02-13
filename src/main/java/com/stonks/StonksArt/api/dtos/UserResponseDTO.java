package com.stonks.StonksArt.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class UserResponseDTO {

    @NotEmpty
    @ApiModelProperty(value = "${user.create.id}") // Ler meta-inf
    private Integer id;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.name}") // Ler meta-inf
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.phone}")
    private String phone;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.email}")
    private String email;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.address}")
    private String address;

    public Integer getId() {
        return id;
    }

    public UserResponseDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserResponseDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserResponseDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
