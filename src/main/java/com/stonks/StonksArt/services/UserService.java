package com.stonks.StonksArt.services;

import com.stonks.StonksArt.api.dtos.CreateUserDTO;
import com.stonks.StonksArt.api.dtos.UserResponseDTO;
import com.stonks.StonksArt.api.mappers.UserMapper;
import com.stonks.StonksArt.entities.User;
import com.stonks.StonksArt.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserResponseDTO create(CreateUserDTO createUserDTO){
        saveUser(UserMapper.toEntity(createUserDTO));
        return null;
    }

    private void validadeUserEmail(String email){
        return;
    }

    private User saveUser(User user){
        return userRepo.save(user);
    }
}
