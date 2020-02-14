package com.stonks.SpringComp.api.controllers;

import com.stonks.SpringComp.api.dtos.CreateRestaurantDTO;
import com.stonks.SpringComp.api.dtos.RestaurantResponseDTO;
import com.stonks.SpringComp.services.RestaurantService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("RestauranteControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/restaurante")
@Api(tags = "Restaurantes")
public class RestauranteController {

    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)

    public String create(@RequestBody @Valid CreateRestaurantDTO createRestaurantdto){
        restaurantService.createRestaurant(createRestaurantdto);
        return "Restaurante Criado!";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Get restaurant")
    public RestaurantResponseDTO get(@RequestParam @Param("id") Integer id){
        return restaurantService.getById(id);
    }
}
