package com.stonks.SpringComp.api.mappers;

import com.stonks.SpringComp.api.dtos.CreateProductDTO;
import com.stonks.SpringComp.api.dtos.CreateRestaurantDTO;
import com.stonks.SpringComp.api.dtos.ProductResponseDTO;
import com.stonks.SpringComp.api.dtos.RestaurantResponseDTO;
import com.stonks.SpringComp.entities.Product;
import com.stonks.SpringComp.entities.Restaurant;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Product toEntity(CreateProductDTO createProductDTO){
        return modelMapper.map(createProductDTO, Product.class);
    }

    public static ProductResponseDTO toResponseDTO(Product product){
        return modelMapper.map(product,ProductResponseDTO.class);
    }
}
