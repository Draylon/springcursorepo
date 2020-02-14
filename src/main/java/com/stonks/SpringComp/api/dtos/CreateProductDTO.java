package com.stonks.SpringComp.api.dtos;

import com.stonks.SpringComp.entities.Restaurant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("CreateProductDTO")
public class CreateProductDTO {

    @NotEmpty
    @ApiModelProperty(value = "${product.create.name}")
    private String name;

    @NotNull
    @Min(value = 1,message = "Valor mínimo é de 1")
    @ApiModelProperty(value = "${product.create.value")
    private Double value;

    @NotNull
    @ApiModelProperty(value = "${product.create.restaurantId")
    private Integer restaurantId;


    public String getName() {
        return name;
    }

    public CreateProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public CreateProductDTO setValue(Double value) {
        this.value = value;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public CreateProductDTO setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }
}
