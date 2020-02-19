package com.stonks.SpringComp.api.controllers;

import com.stonks.SpringComp.api.dtos.CreateUserDTO;
import com.stonks.SpringComp.api.dtos.UserResponseDTO;
import com.stonks.SpringComp.services.UserService;
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

    public String create(@ApiParam(value = "Contem info do user") @RequestBody @Valid CreateUserDTO createUserDTO){
        userService.create(createUserDTO);
        return "Usuário Criado!";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping( value = "/GetUser")
    public UserResponseDTO get(@RequestParam @Param("id") Integer id){
        return userService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/GetUserList")
    public List<UserResponseDTO> getList(){
        return userService.listAll();
    }
}
