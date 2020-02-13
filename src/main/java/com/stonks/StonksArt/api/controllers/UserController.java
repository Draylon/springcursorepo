package com.stonks.StonksArt.api.controllers;

import com.stonks.StonksArt.api.dtos.CreateUserDTO;
import com.stonks.StonksArt.api.dtos.UserResponseDTO;
import com.stonks.StonksArt.api.mappers.UserMapper;
import com.stonks.StonksArt.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("UserControllerV1")
@RequestMapping(RestPath.BASE_PATH+"/user")
@Api(tags = "Usuarios")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)

    public void create(@ApiParam(value = "Contem info do user") @RequestBody @Valid CreateUserDTO createUserDTO){
        userService.create(createUserDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping( value = "/get")
    public UserResponseDTO get(@RequestBody @Param("id") Integer id){
        return userService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list")
    public List<UserResponseDTO> list(){
        return userService.listAll();
    }
}
