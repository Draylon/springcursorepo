package com.stonks.StonksArt.api.controllers;

import com.stonks.StonksArt.api.dtos.CreateRestaurantDTO;
import com.stonks.StonksArt.api.dtos.RestaurantResponseDTO;
import com.stonks.StonksArt.services.RestaurantService;
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

    public void create(@RequestBody @Valid CreateRestaurantDTO createRestaurantdto){
        restaurantService.createRestaurant(createRestaurantdto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public RestaurantResponseDTO get(@RequestParam @Param("id") Integer id){
        return restaurantService.getById(id);
    }
}
