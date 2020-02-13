package com.stonks.StonksArt.services;

import com.stonks.StonksArt.api.dtos.CreateUserDTO;
import com.stonks.StonksArt.api.dtos.RestaurantResponseDTO;
import com.stonks.StonksArt.api.dtos.UserResponseDTO;
import com.stonks.StonksArt.api.mappers.UserMapper;
import com.stonks.StonksArt.entities.Restaurant;
import com.stonks.StonksArt.entities.User;
import com.stonks.StonksArt.exceptions.AlreadyExistsException;
import com.stonks.StonksArt.exceptions.NotFoundException;
import com.stonks.StonksArt.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserResponseDTO create(CreateUserDTO createUserDTO){
        validateUserEmail(createUserDTO.getEmail());
        saveUser(UserMapper.toEntity(createUserDTO));
        User user = userRepo.findByEmail(createUserDTO.getEmail());
        UserResponseDTO response = UserMapper.toResponseDTO(user);
        return response;
    }

    private void validateUserEmail(String email){
        User user = userRepo.findByEmail(email);
        if(user != null) {
            throw new AlreadyExistsException("Usuário já cadastrado!");
        }
    }

    private User createUser(CreateUserDTO createUserDTO){ // not being used
        return new User()
                .setName(createUserDTO.getName())
                .setAddress(createUserDTO.getAddress())
                .setEmail(createUserDTO.getEmail())
                .setPhone(createUserDTO.getPhone())
                .setPword(createUserDTO.getPword());
    }
    private User saveUser(User user){
        return userRepo.save(user);
    }

    public UserResponseDTO findById(Integer id){
        Optional<User> user = userRepo.findById(id);
        if(!user.isPresent())
            throw new NotFoundException("Não existe usuário para o id: "+ id);
        return UserMapper.toResponseDTO(user.get());
    }

    public UserResponseDTO getById(Integer id){
        Optional<User> optional = userRepo.findById(id);
        if(optional.isPresent()) {
            User user = optional.get();
            return UserMapper.toResponseDTO(user);
        }
        return null;
    }

    public List<UserResponseDTO> listAll(){
        List<User> users = userRepo.findAll();
        return users.stream().map(UserMapper::toResponseDTO).collect(Collectors.toList());
    }

}
