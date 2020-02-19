package com.stonks.SpringComp.services;

import com.stonks.SpringComp.api.dtos.CreateOrderItemDTO;
import com.stonks.SpringComp.api.dtos.OrderItemDTO;
import com.stonks.SpringComp.api.mappers.OrderItemMapper;
import com.stonks.SpringComp.api.mappers.ProductMapper;
import com.stonks.SpringComp.entities.Order;
import com.stonks.SpringComp.entities.OrderItem;
import com.stonks.SpringComp.exceptions.NotFoundException;
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


    public List<OrderItem> createOrderItemList(List<CreateOrderItemDTO> items, Order order){
        return items.stream().map(createOrderItemDTO ->
                buildOrderItem(createOrderItemDTO,order)
        ).collect(Collectors.toList());
    }

    public List<OrderItemDTO> buildOrderItemDTOs(List<OrderItem> list){
        return list.stream().map(orderItem -> {
            return new OrderItemDTO()
                    .setId(orderItem.getId())
                    .setQuantity(orderItem.getQuantity())
                    .setProductResponse(ProductMapper.toResponseDTO(productService.findById(orderItem.getProduct().getId())));
        }).collect(Collectors.toList());
    }

    private OrderItem buildOrderItem(CreateOrderItemDTO createOrderItemDTO, Order order){
        OrderItem orderItem = new OrderItem()
                .setOrder(order)
                .setProduct(productService.findById(createOrderItemDTO.getProductId()))
                .setQuantity(createOrderItemDTO.getQuantity());
        return orderItem;
    }


    public OrderItem findById(Integer id){
        Optional<OrderItem> optionalOrderItem = orderItemRepo.findById(id);
        if(!optionalOrderItem.isPresent())
            throw new NotFoundException("Order Item: "+id+" not found!");
        return optionalOrderItem.get();
    }

    public OrderItemDTO getById(Integer id){
        OrderItem orderItem = findById(id);
        return OrderItemMapper.toItemDto(orderItem);
    }
}
