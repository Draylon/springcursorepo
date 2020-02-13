package com.stonks.SpringComp.api.mappers;

import com.stonks.SpringComp.api.dtos.CreateRestaurantDTO;
import com.stonks.SpringComp.api.dtos.RestaurantResponseDTO;
import com.stonks.SpringComp.entities.Restaurant;

import org.modelmapper.ModelMapper;

public class RestaurantMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Restaurant toEntity(CreateRestaurantDTO createRestaurantDTO){
        return modelMapper.map(createRestaurantDTO,Restaurant.class);
    }

    public static RestaurantResponseDTO toResponseDTO(Restaurant restaurant){
        return modelMapper.map(restaurant,RestaurantResponseDTO.class);
    }

}
