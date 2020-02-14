package com.stonks.SpringComp.entities;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME", nullable = false)
    private String name;

    @Column(name = "VALOR",nullable = false)
    private Double value;

    @ManyToOne()
    @JoinColumn(name = "RESTAURANTE",nullable = false)
    private Restaurant restaurant;


    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Product setValue(Double value) {
        this.value = value;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Product setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
