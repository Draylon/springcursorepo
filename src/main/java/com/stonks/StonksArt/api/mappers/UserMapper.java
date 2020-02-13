package com.stonks.StonksArt.api.mappers;

import com.stonks.StonksArt.api.dtos.CreateUserDTO;
import com.stonks.StonksArt.api.dtos.UserResponseDTO;
import com.stonks.StonksArt.entities.User;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static User toEntity(CreateUserDTO createUserDTO){
        return modelMapper.map(createUserDTO,User.class);
    }

    public static UserResponseDTO toResponseDTO(User user){
        return modelMapper.map(user,UserResponseDTO.class);
    }
}
