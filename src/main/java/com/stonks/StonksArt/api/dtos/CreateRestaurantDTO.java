package com.stonks.StonksArt.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class CreateRestaurantDTO {

    @NotEmpty
    @ApiModelProperty(value = "Nome")
    private String name;
    @NotEmpty
    @ApiModelProperty(value = "Email")
    private String email;
    @NotEmpty
    @ApiModelProperty(value = "CNPJ")
    private String cnpj;
    @NotEmpty
    @ApiModelProperty(value = "Telefone")
    private String phone;

    public String getName() {
        return name;
    }

    public CreateRestaurantDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateRestaurantDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public CreateRestaurantDTO setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateRestaurantDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }


}
