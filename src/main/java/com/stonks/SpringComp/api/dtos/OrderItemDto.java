package com.stonks.SpringComp.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("OrderItemDTO")
public class OrderItemDto {

    @NotNull
    @ApiModelProperty(value = "${orderItem.create.pid}")
    private Integer orderItemId;

    @Min( value = 1,message = "Quantidade mínima é 1")
    @ApiModelProperty(value = "${orderItem.create.quantity}")
    private Integer quantity;

    @NotNull
    @ApiModelProperty(value = "${orderItem.create.productResponse}")
    private ProductResponseDTO productResponse;


    public Integer getOrderItemId() {
        return orderItemId;
    }

    public OrderItemDto setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductResponseDTO getProductResponse() {
        return productResponse;
    }

    public OrderItemDto setProductResponse(ProductResponseDTO productResponse) {
        this.productResponse = productResponse;
        return this;
    }
}
