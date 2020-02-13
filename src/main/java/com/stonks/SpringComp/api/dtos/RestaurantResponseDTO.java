package com.stonks.SpringComp.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class RestaurantResponseDTO {

    @NotEmpty
    @ApiModelProperty(value = "${restaurant.create.id}")
    private Integer id;
    @NotEmpty
    @ApiModelProperty(value = "${restaurant.create.name}")
    private String name;
    @NotEmpty
    @ApiModelProperty(value = "${restaurant.create.email}")
    private String email;
    @NotEmpty
    @ApiModelProperty(value = "${restaurant.create.phone}")
    private String phone;

    public Integer getId() {
        return id;
    }

    public RestaurantResponseDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RestaurantResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RestaurantResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public RestaurantResponseDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
