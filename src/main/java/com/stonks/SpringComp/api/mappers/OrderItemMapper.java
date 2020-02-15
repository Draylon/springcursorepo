package com.stonks.SpringComp.api.mappers;

import com.stonks.SpringComp.api.dtos.OrderItemDto;
import com.stonks.SpringComp.entities.OrderItem;
import org.modelmapper.ModelMapper;

public class OrderItemMapper {

    private static final ModelMapper orderItemMapper = new ModelMapper();

    public static OrderItem toEntity(OrderItemDto orderItemDto){
        return orderItemMapper.map(orderItemDto,OrderItem.class);
    }

    public static OrderItemDto toItemDto(OrderItem orderItem){
        return orderItemMapper.map(orderItem,OrderItemDto.class);
    }
}
