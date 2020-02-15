package com.stonks.SpringComp.api.dtos;

import com.stonks.SpringComp.enums.OrderStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@ApiModel("OrderResponseDTO")
public class OrderResponseDTO {

    @ApiModelProperty(value = "")
    private Integer orderId;

    @ApiModelProperty(value = "")
    private Double totalValue;

    @ApiModelProperty(value = "")
    private OrderStatusEnum orderStatusEnum;

    @ApiModelProperty(value = "")
    private UserResponseDTO userResponse;

    @ApiModelProperty(value = "")
    private RestaurantResponseDTO restaurantResponse;

    @ApiModelProperty(value = "")
    private List<OrderItemDto> items;


    public Integer getId() {
        return orderId;
    }

    public OrderResponseDTO setId(Integer id) {
        this.orderId = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public OrderResponseDTO setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public OrderResponseDTO setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
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

    public List<OrderItemDto> getItems() {
        return items;
    }

    public OrderResponseDTO setItems(List<OrderItemDto> items) {
        this.items = items;
        return this;
    }
}
