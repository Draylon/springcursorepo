package com.stonks.SpringComp.api.mappers;

import com.stonks.SpringComp.api.dtos.CreateOrderDTO;
import com.stonks.SpringComp.api.dtos.OrderItemDto;
import com.stonks.SpringComp.api.dtos.OrderResponseDTO;
import com.stonks.SpringComp.entities.Order;
import com.stonks.SpringComp.entities.OrderItem;
import org.modelmapper.ModelMapper;

public class OrderMapper {

    private static final ModelMapper orderMapper = new ModelMapper();

    public static Order toEntity(CreateOrderDTO createOrderDTO){

        return orderMapper.map(createOrderDTO,Order.class);
    }

    public static OrderResponseDTO toResponseDTO(Order order){
        return orderMapper.map(order, OrderResponseDTO.class);
    }

}
