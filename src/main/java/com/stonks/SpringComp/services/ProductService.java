package com.stonks.SpringComp.services;

import com.stonks.SpringComp.api.dtos.CreateProductDTO;
import com.stonks.SpringComp.api.dtos.ProductResponseDTO;
import com.stonks.SpringComp.api.dtos.RestaurantResponseDTO;
import com.stonks.SpringComp.api.mappers.ProductMapper;
import com.stonks.SpringComp.api.mappers.RestaurantMapper;
import com.stonks.SpringComp.entities.Product;
import com.stonks.SpringComp.entities.Restaurant;
import com.stonks.SpringComp.exceptions.NotFoundException;
import com.stonks.SpringComp.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    RestaurantService restaurantService;

    public ProductResponseDTO createProduct(CreateProductDTO createProductDTO){

        Restaurant restaurant = restaurantService.findById(createProductDTO.getRestaurantId());

        Product product = new Product()
                .setName(createProductDTO.getName())
                .setRestaurant(restaurant)
                .setValue(createProductDTO.getValue());

        productRepo.save(product);

        RestaurantResponseDTO restaurantResponseDTO = RestaurantMapper.toResponseDTO(restaurant);
        return new ProductResponseDTO()
                .setName(product.getName())
                .setRestaurant(restaurantResponseDTO)
                .setValue(product.getValue());
    }

    public ProductResponseDTO getById(Integer id){
        Product product = findById(id);
        return ProductMapper.toResponseDTO(product);
    }

    public Product findById(Integer id){
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(!optionalProduct.isPresent())
            throw new NotFoundException("Produto não encontrado");
        return optionalProduct.get();
    }

}
