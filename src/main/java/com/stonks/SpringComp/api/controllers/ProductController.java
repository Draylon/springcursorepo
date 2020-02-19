package com.stonks.SpringComp.api.controllers;

import com.stonks.SpringComp.api.dtos.CreateProductDTO;
import com.stonks.SpringComp.api.dtos.ProductResponseDTO;
import com.stonks.SpringComp.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("ProductControllerV1")
@RequestMapping(RestPath.BASE_PATH+"/product")
@Api(tags = "Produto")
public class ProductController {

    @Autowired
    ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 201,message = "Produto Criado",response = ProductResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro ao Processar Pedido!", response = String.class)
    })

    public String create(@RequestBody @Valid CreateProductDTO createProductDTO){
        productService.createProduct(createProductDTO);
        return "Produto Criado!";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping( value = "/GetProduct")
    public ProductResponseDTO get(@RequestParam @Param("id") Integer id){
        return productService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/GetProductList")
    public List<ProductResponseDTO> getList(){
        return productService.getAll();
    }
}
