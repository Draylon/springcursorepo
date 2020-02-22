package com.stonks.SpringComp.api.controllers;

import com.stonks.SpringComp.api.dtos.CreateOrderDTO;
import com.stonks.SpringComp.api.dtos.OrderResponseDTO;
import com.stonks.SpringComp.api.dtos.UpdateOrderDTO;
import com.stonks.SpringComp.enums.OrderStatusEnum;
import com.stonks.SpringComp.services.OrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("PedidoControllerV1")
@RequestMapping(RestPath.BASE_PATH+"/pedido")
@Api(tags = "Pedido")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 201,message = "Pedido realizado",response = OrderResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro ao Processar Pedido!", response = String.class)
    })

    public String create(@ApiParam(value = "Informações para criar pedido") @RequestBody @Valid CreateOrderDTO createOrderDTO){
        orderService.create(createOrderDTO);
        return "Pedido Criado";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/GetOrder")
    public OrderResponseDTO get(@RequestParam @Param("id") Integer id){
        return orderService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/GetOrderList")
    public List<OrderResponseDTO> getList(){
        return orderService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = {"/UpdateOrderStatus/{id}/{orderStatus}"})
    public String updateOrderStatus(@PathVariable @Param("id") Integer id, @ApiParam(allowableValues = "OPEN,CONFIRMED,IN_TRANSIT,COMPLETE,EXPIRED,CANCELED,ERROR") @PathVariable @Param("orderStatus") OrderStatusEnum orderStatus){
        orderService.updateOrderStatus(id,orderStatus);
        return "Order Status Updated";
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/UpdateOrder",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateOrder(@RequestBody @Valid UpdateOrderDTO updateOrderDTO){
        orderService.updateOrder(updateOrderDTO);
        return "Order Updated!";
    }
}
