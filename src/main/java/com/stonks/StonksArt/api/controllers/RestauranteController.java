package com.stonks.StonksArt.api.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("RestauranteControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/restaurante")
@Api(tags = "Restaurantes")
public class RestauranteController {

}
