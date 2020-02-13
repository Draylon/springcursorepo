package com.stonks.SpringComp.api.mappers;

import com.stonks.SpringComp.api.dtos.CreateUserDTO;
import com.stonks.SpringComp.api.dtos.UserResponseDTO;
import com.stonks.SpringComp.entities.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static User toEntity(CreateUserDTO createUserDTO){
        return modelMapper.map(createUserDTO,User.class);
    }

    public static UserResponseDTO toResponseDTO(User user){
        return modelMapper.map(user,UserResponseDTO.class);
    }

}
