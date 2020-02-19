package com.stonks.SpringComp.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("CreateOrderItemDTO")
public class CreateOrderItemDTO {

    @NotNull
    @ApiModelProperty(value = "${orderItem.create.productId}")
    private Integer productId;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "${orderItem.create.quantity}")
    private Integer quantity;


    public Integer getProductId() {
        return productId;
    }

    public CreateOrderItemDTO setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public CreateOrderItemDTO setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
