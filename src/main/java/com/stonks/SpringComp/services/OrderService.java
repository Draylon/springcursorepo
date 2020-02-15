package com.stonks.SpringComp.services;

import com.stonks.SpringComp.api.dtos.CreateOrderDTO;
import com.stonks.SpringComp.api.dtos.OrderItemDto;
import com.stonks.SpringComp.api.dtos.OrderResponseDTO;
import com.stonks.SpringComp.api.dtos.ProductResponseDTO;
import com.stonks.SpringComp.api.mappers.OrderMapper;
import com.stonks.SpringComp.api.mappers.ProductMapper;
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
        Order order = findById(createOrder.getId());

        return OrderMapper.toResponseDTO(order);
    }

    public Order createOrder(CreateOrderDTO createOrderDTO){

        Order order = new Order()
                .setItems(orderItemService.getOrderItemList(createOrderDTO.getItemList()))
                .setStatus(OrderStatusEnum.OPEN)
                .setRestaurant(restaurantService.findById(createOrderDTO.getRestaurantId()))
                .setUser(userService.getById(createOrderDTO.getUserId()))
                .setTotalValue(calculateOrderTotalValue(createOrderDTO.getItemList()));

        orderRepo.save(order);
        return order;
    }

    public Double calculateOrderTotalValue(List<OrderItemDto> itens){
//        Double value = 0.0;
//        for(OrderItemDto item:itens){
//            value += item.getQuantity() * productService.findById(item.getProductId()).getValue();
//        }
//        return value;

        return itens.stream().map(orderItemDto -> {
            Product p = productService.findById(orderItemDto.getProductResponse().getProductId());
            Double v = orderItemDto.getQuantity() * p.getValue();
            return v;
        }).reduce(0d,Double::sum);
    }


    public OrderResponseDTO getById(Integer id){
        Order order = findById(id);
        return OrderMapper.toResponseDTO(order);
    }

    public Order findById(Integer id){
        Optional<Order> optionalOrder = orderRepo.findById(id);
        if(!optionalOrder.isPresent())
            throw new NotFoundException("Produto não encontrado");
        return optionalOrder.get();
    }

    public List<OrderResponseDTO> getAll(){
        List<Order> list = orderRepo.findAll();
        // return list.stream().map(ProductMapper::toResponseDTO).collect(Collectors.toList());
        List<OrderResponseDTO> response = null;
        for (Order item:list) response.add(OrderMapper.toResponseDTO(item));
        return response;
    }
}
