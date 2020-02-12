package com.stonks.StonksArt.services;

import com.stonks.StonksArt.api.dtos.CreateRestaurantDTO;
import com.stonks.StonksArt.api.dtos.RestaurantResponseDTO;
import com.stonks.StonksArt.entities.Restaurant;
import com.stonks.StonksArt.repositories.RestaurantRepo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public void createRestaurant(CreateRestaurantDTO createRestaurantDto){
        //Validações aqui

        Restaurant restaurant = new Restaurant()
                .setEmail(createRestaurantDto.getEmail())
                .setCnpj(createRestaurantDto.getCnpj())
                .setName(createRestaurantDto.getName())
                .setTelefone(createRestaurantDto.getPhone());

        restaurantRepo.save(restaurant);
    }

    public RestaurantResponseDTO getById(Integer id){
        Optional<Restaurant> optional = restaurantRepo.findById(id);
        if(optional.isPresent()) {
            Restaurant restaurant = optional.get();
            return new RestaurantResponseDTO()
                    .setEmail(restaurant.getEmail())
                    .setName(restaurant.getName())
                    .setPhone(restaurant.getTelefone());
        }
        return null;
    }
}
