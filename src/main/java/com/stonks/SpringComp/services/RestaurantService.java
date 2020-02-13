package com.stonks.SpringComp.services;

import com.stonks.SpringComp.api.dtos.CreateRestaurantDTO;
import com.stonks.SpringComp.api.dtos.RestaurantResponseDTO;
import com.stonks.SpringComp.api.mappers.RestaurantMapper;
import com.stonks.SpringComp.entities.Restaurant;
import com.stonks.SpringComp.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public void createRestaurant(CreateRestaurantDTO createRestaurantDto){
        //Validações aqui

        Restaurant restaurant = RestaurantMapper.toEntity(createRestaurantDto);

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
