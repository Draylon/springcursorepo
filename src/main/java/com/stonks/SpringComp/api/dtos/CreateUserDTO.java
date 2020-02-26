package com.stonks.SpringComp.api.dtos;

import com.stonks.SpringComp.enums.UserTypeEnum;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateUserDTO {
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
    @ApiModelProperty(value = "${user.create.pword}")
    private String pword;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.address}")
    private String address;

    @NotNull
    @ApiModelProperty(value = "${user.create.userType}")
    private UserTypeEnum userType;

    public String getName() {
        return name;
    }

    public CreateUserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateUserDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPword() {
        return pword;
    }

    public CreateUserDTO setPword(String pword) {
        this.pword = pword;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CreateUserDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public CreateUserDTO setUserType(UserTypeEnum userType) {
        this.userType = userType;
        return this;
    }
}
