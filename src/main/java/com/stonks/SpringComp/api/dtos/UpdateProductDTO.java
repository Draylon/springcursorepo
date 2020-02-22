package com.stonks.SpringComp.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateProductDTO {

    @ApiModelProperty(value = "${product.update.id}")
    private Integer id;

    @ApiModelProperty(value = "${product.create.name}")
    private String name;

    @Min(value = 1,message = "Valor mínimo é de 1")
    @ApiModelProperty(value = "${product.create.value}")
    private Double value;

    @ApiModelProperty(value = "${product.create.restaurantId}")
    private Integer restaurantId;

    @ApiModelProperty(value = "${product.update.isvalid}")
    private Boolean isValid;

    public Integer getId() {
        return id;
    }

    public UpdateProductDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UpdateProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public UpdateProductDTO setValue(Double value) {
        this.value = value;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public UpdateProductDTO setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public Boolean getValid() {
        return isValid;
    }

    public UpdateProductDTO setValid(Boolean valid) {
        isValid = valid;
        return this;
    }
}
