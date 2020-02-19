package com.stonks.SpringComp.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("OrderItemDTO")
public class OrderItemDTO {

    @ApiModelProperty(value = "${orderItem.response.id}")
    private Integer id;

    @ApiModelProperty(value = "${orderItem.response.quantity}")
    private Integer quantity;

    @ApiModelProperty(value = "${orderItem.response.productResponse}")
    private ProductResponseDTO productResponse;

    public Integer getId() {
        return id;
    }

    public OrderItemDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemDTO setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductResponseDTO getProductResponse() {
        return productResponse;
    }

    public OrderItemDTO setProductResponse(ProductResponseDTO productResponse) {
        this.productResponse = productResponse;
        return this;
    }
}
