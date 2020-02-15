package com.stonks.SpringComp.services;

import com.stonks.SpringComp.api.dtos.OrderItemDto;
import com.stonks.SpringComp.api.mappers.OrderItemMapper;
import com.stonks.SpringComp.entities.Order;
import com.stonks.SpringComp.entities.OrderItem;
import com.stonks.SpringComp.repositories.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private ProductService productService;

    public List<OrderItem> getOrderItemList(List<OrderItemDto> itens){
        return itens.stream().map(OrderItemMapper::toEntity).collect(Collectors.toList());
    }

    private OrderItem buildOrderItem(OrderItemDto orderItemDto,Order order){
        OrderItem orderItem = new OrderItem()
                .setProduct(productService.findById(orderItemDto.getProductResponse().getProductId()))
                .setOrder(order)
                .setQuantity(orderItemDto.getQuantity());
        return orderItem;
    }

    public OrderItemDto findById(Integer id){
        Optional<OrderItem> optionalOrderItem = orderItemRepo.findById(id);
        if(optionalOrderItem.isPresent())
            return OrderItemMapper.toItemDto(optionalOrderItem.get());
        return null;
    }
}
