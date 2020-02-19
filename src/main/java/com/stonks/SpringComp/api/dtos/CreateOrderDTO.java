package com.stonks.SpringComp.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("CreateOrderDTO")
public class CreateOrderDTO {

    @NotNull
    @ApiModelProperty(value = "${order.create.userId}")
    private Integer userId;

    @NotEmpty
    @ApiModelProperty(value = "${order.create.itemlist}")
    private List<CreateOrderItemDTO> itemList;

    @NotNull
    @ApiModelProperty(value = "${restaurant.response.id}")
    private Integer restaurantId;


    public Integer getUserId() {
        return userId;
    }

    public CreateOrderDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public List<CreateOrderItemDTO> getItemList() {
        return itemList;
    }

    public CreateOrderDTO setItemList(List<CreateOrderItemDTO> itemList) {
        this.itemList = itemList;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public CreateOrderDTO setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }
}
