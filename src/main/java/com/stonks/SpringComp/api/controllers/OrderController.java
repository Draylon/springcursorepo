package com.stonks.SpringComp.api.controllers;

import com.stonks.SpringComp.api.dtos.CreateOrderDTO;
import com.stonks.SpringComp.api.dtos.OrderResponseDTO;
import com.stonks.SpringComp.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    /*private void stonks(){
        String lmao = "POST\n" + "/api/v1/pedido\n" + "create\n" +
                "GET\n" + "/api/v1/pedido/Get\n" + "get\n" +
                "HEAD\n" + "/api/v1/pedido/Get\n" + "get\n" +
                "POST\n" + "/api/v1/pedido/Get\n" + "get\n" +
                "PUT\n" + "/api/v1/pedido/Get\n" + "get\n" +
                "DELETE\n" + "/api/v1/pedido/Get\n" + "get\n" +
                "OPTIONS\n" + "/api/v1/pedido/Get\n" + "get\n" +
                "PATCH\n" + "/api/v1/pedido/Get\n" + "get";
    }*/
}
