package com.stonks.SpringComp.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;

@ApiModel("ProductResponseDTO")
public class ProductResponseDTO {

    @ApiModelProperty(value = "")
    private Integer productId;

    @ApiModelProperty(value = "${product.response.name}")
    private String name;

    @Min(value = 1,message = "Valor mínimo é de 1")
    @ApiModelProperty(value = "${product.response.value")
    private Double value;

    @ApiModelProperty(value = "${product.response.restaurant")
    private RestaurantResponseDTO restaurant;

    @ApiModelProperty(value = "${product.response.isvalid}")
    private Boolean isValid;

    public Integer getProductId() {
        return productId;
    }

    public ProductResponseDTO setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ProductResponseDTO setValue(Double value) {
        this.value = value;
        return this;
    }

    public RestaurantResponseDTO getRestaurant() {
        return restaurant;
    }

    public ProductResponseDTO setRestaurant(RestaurantResponseDTO restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public Boolean getValid() {
        return isValid;
    }

    public ProductResponseDTO setValid(Boolean valid) {
        isValid = valid;
        return this;
    }
}

