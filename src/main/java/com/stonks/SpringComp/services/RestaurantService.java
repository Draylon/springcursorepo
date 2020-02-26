package com.stonks.SpringComp.services;

import com.stonks.SpringComp.api.dtos.CreateRestaurantDTO;
import com.stonks.SpringComp.api.dtos.RestaurantResponseDTO;
import com.stonks.SpringComp.api.mappers.RestaurantMapper;
import com.stonks.SpringComp.entities.Restaurant;
import com.stonks.SpringComp.exceptions.NotFoundException;
import com.stonks.SpringComp.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return RestaurantMapper.toResponseDTO(restaurant);
    }

    public Restaurant findById(Integer id){
        Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(id);
        if(!optionalRestaurant.isPresent())
            throw new NotFoundException("Restaurante não encontrado");
        return optionalRestaurant.get();
    }

    public List<RestaurantResponseDTO> getAll(){
        return restaurantRepo.findAll().stream().map(RestaurantMapper::toResponseDTO).collect(Collectors.toList());
    }

    public List<RestaurantResponseDTO> queryAlike(String name) {
        List alikeRestaurants = restaurantRepo.findAll().stream().map(restaurant -> {
            if(restaurant.getName().toLowerCase().matches(name))
                return getById(restaurant.getId());;
            return null;
        }).collect(Collectors.toList());
        return alikeRestaurants;
    }
}
