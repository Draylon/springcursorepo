package com.stonks.SpringComp.services;

import com.stonks.SpringComp.api.dtos.*;
import com.stonks.SpringComp.api.mappers.OrderItemMapper;
import com.stonks.SpringComp.api.mappers.OrderMapper;
import com.stonks.SpringComp.entities.Order;
import com.stonks.SpringComp.entities.OrderItem;
import com.stonks.SpringComp.entities.Product;
import com.stonks.SpringComp.enums.OrderStatusEnum;
import com.stonks.SpringComp.exceptions.NotFoundException;
import com.stonks.SpringComp.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    public OrderRepo orderRepo;

    @Autowired
    public RestaurantService restaurantService;

    @Autowired
    public UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderItemService orderItemService;

    public OrderResponseDTO create(CreateOrderDTO createOrderDTO){
        Order createOrder = createOrder(createOrderDTO);

        Order order = orderRepo.save(createOrder);

        
        return new OrderResponseDTO()
                .setOrderId(order.getId())
                .setOrderStatus(order.getStatus())
                .setTotalValue(order.getTotalValue())
                .setItems(orderItemService.buildOrderItemDTOs(order.getItems()));

    }

    public Order createOrder(CreateOrderDTO createOrderDTO){
        Order order = new Order();
        List<OrderItem> items = orderItemService.createOrderItemList(createOrderDTO.getItemList(),order);
        order.setItems(items)
                .setStatus(OrderStatusEnum.OPEN)
                .setRestaurant(restaurantService.findById(createOrderDTO.getRestaurantId()))
                .setUser(userService.findById(createOrderDTO.getUserId()))
                .setTotalValue(calculateOrderTotalValue(createOrderDTO.getItemList()));

        return order;
    }

    public Double calculateOrderTotalValue(List<CreateOrderItemDTO> items){
        return items.stream().map(orderItemDto -> {
            Product p = productService.findById(orderItemDto.getProductId());
            Double v = orderItemDto.getQuantity() * p.getValue();
            return v;
        }).reduce(0d,Double::sum);
    }

    public OrderResponseDTO setResponseDTO(Order order){
        return new OrderResponseDTO()
                .setTotalValue(order.getTotalValue())
                .setOrderStatus(order.getStatus())
                .setOrderId(order.getId())
                .setUserResponse(userService.getById(order.getUser().getId()))
                .setRestaurantResponse(restaurantService.getById(order.getRestaurant().getId()))
                .setItems(orderItemService.buildOrderItemDTOs(order.getItems()));
    }


    public OrderResponseDTO getById(Integer id){
        Order order = findById(id);
        return setResponseDTO(order);
    }

    public Order findById(Integer id){
        Optional<Order> optionalOrder = orderRepo.findById(id);
        if(!optionalOrder.isPresent())
            throw new NotFoundException("Pedido: "+id+" não encontrado!");
        return optionalOrder.get();
    }

    public List<OrderResponseDTO> getAll(){
        List<Order> list = orderRepo.findAll();
         return list.stream().map(order -> {
             return setResponseDTO(order);
         }).collect(Collectors.toList());
//        List<OrderResponseDTO> response = null;
//        for (Order item:list) response.add(OrderMapper.toResponseDTO(item));
//        return response;
    }

    public void updateOrder(UpdateOrderDTO updateOrderDTO) {
        Order order = findById(updateOrderDTO.getId());

        if(updateOrderDTO.getTotalValue() != null)
            order.setTotalValue(updateOrderDTO.getTotalValue());
        if(updateOrderDTO.getRestaurantId() != null)
            order.setRestaurant(restaurantService.findById(updateOrderDTO.getRestaurantId()));
        if(updateOrderDTO.getOrderStatusEnum() != null)
            order.setStatus(updateOrderDTO.getOrderStatusEnum());
        if(updateOrderDTO.getUserId() != null)
            order.setUser(userService.findById(updateOrderDTO.getUserId()));
//        if(updateOrderDTO.getItems() != null)
//            order.setItems(orderItemService.createOrderItemList(updateOrderDTO.getItems(),order));
            //order.setItems(updateOrderDTO.getItems().stream().map(OrderItemMapper::toEntity).collect(Collectors.toList()));
            //Provavelmente não vai mapear pra orderItem certo
        System.out.println(order.toString());
        orderRepo.save(order);
    }

    public void updateOrderStatus(Integer id, OrderStatusEnum orderStatusEnum) {
        //UpdateOrderDTO p = new UpdateOrderDTO().setId(id).setOrderStatusEnum(OrderStatusEnum.getEnum(orderStatusEnum));
        //System.out.println(orderStatusEnum + "   "+p.getOrderStatusEnum() + "   " + p.getId());
        updateOrder(new UpdateOrderDTO().setId(id).setOrderStatusEnum(orderStatusEnum));
    }

}