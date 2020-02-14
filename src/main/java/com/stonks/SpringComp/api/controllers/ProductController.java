package com.stonks.SpringComp.api.controllers;

import com.stonks.SpringComp.api.dtos.CreateProductDTO;
import com.stonks.SpringComp.api.dtos.ProductResponseDTO;
import com.stonks.SpringComp.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("ProductControllerV1")
@RequestMapping(RestPath.BASE_PATH+"/product")
@Api(tags = "Produto")
public class ProductController {

    ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 201,message = "Produto Criado",response = ProductResponseDTO.class)
    })

    public void create(@RequestBody @Valid CreateProductDTO createProductDTO){
        productService.createProduct(createProductDTO);
    }
}
