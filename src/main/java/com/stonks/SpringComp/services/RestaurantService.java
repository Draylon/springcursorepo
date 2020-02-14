package com.stonks.SpringComp.services;

import com.stonks.SpringComp.api.dtos.CreateRestaurantDTO;
import com.stonks.SpringComp.api.dtos.RestaurantResponseDTO;
import com.stonks.SpringComp.api.mappers.RestaurantMapper;
import com.stonks.SpringComp.entities.Restaurant;
import com.stonks.SpringComp.exceptions.NotFoundException;
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

        Restaurant restaurant = findById(id);

        return new RestaurantResponseDTO()
                    .setEmail(restaurant.getEmail())
                    .setName(restaurant.getName())
                    .setPhone(restaurant.getTelefone());
    }

    public Restaurant findById(Integer id){
        Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(id);
        if(!optionalRestaurant.isPresent())
            throw new NotFoundException("Restaurante não encontrado");
        return optionalRestaurant.get();
    }
}
