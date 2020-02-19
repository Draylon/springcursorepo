package com.stonks.SpringComp.api.dtos;

import com.stonks.SpringComp.enums.OrderStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;


@ApiModel("OrderResponseDTO")
public class OrderResponseDTO {

    @NotNull
    @ApiModelProperty(value = "${order.response.id}")
    private Integer orderId;

    @NotNull
    @ApiModelProperty(value = "${order.response.totalValue}")
    private Double totalValue;

    @NotNull
    @ApiModelProperty(value = "${order.response.orderStatus}")
    private OrderStatusEnum orderStatus;

    @NotNull
    @ApiModelProperty(value = "${order.response.userResponse}")
    private UserResponseDTO userResponse;

    @NotNull
    @ApiModelProperty(value = "${order.response.restaurantResponse}")
    private RestaurantResponseDTO restaurantResponse;

    @NotNull
    @ApiModelProperty(value = "${order.response.itemsList}")
    private List<OrderItemDTO> items;


    public Integer getOrderId() {
        return orderId;
    }

    public OrderResponseDTO setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public OrderResponseDTO setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public OrderResponseDTO setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public UserResponseDTO getUserResponse() {
        return userResponse;
    }

    public OrderResponseDTO setUserResponse(UserResponseDTO userResponse) {
        this.userResponse = userResponse;
        return this;
    }

    public RestaurantResponseDTO getRestaurantResponse() {
        return restaurantResponse;
    }

    public OrderResponseDTO setRestaurantResponse(RestaurantResponseDTO restaurantResponse) {
        this.restaurantResponse = restaurantResponse;
        return this;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public OrderResponseDTO setItems(List<OrderItemDTO> items) {
        this.items = items;
        return this;
    }
}
