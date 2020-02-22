package com.stonks.SpringComp.api.dtos;

import com.stonks.SpringComp.enums.OrderStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("UpdateOrderDTO")
public class UpdateOrderDTO {

    @ApiModelProperty(value = "${order.update.id}")
    private Integer id;

    @ApiModelProperty(value = "${order.update.totalValue}")
    private Double totalValue;

    @ApiModelProperty(value = "${order.update.orderStatus}")
    private OrderStatusEnum orderStatusEnum;

    @ApiModelProperty(value = "${order.update.userId}")
    private Integer userId;

    @ApiModelProperty(value = "${order.update.restaurantId}")
    private Integer restaurantId;


    public Integer getId() {
        return id;
    }

    public UpdateOrderDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public UpdateOrderDTO setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public UpdateOrderDTO setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UpdateOrderDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public UpdateOrderDTO setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

}
