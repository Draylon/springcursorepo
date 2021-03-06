package com.stonks.SpringComp.entities;

import com.stonks.SpringComp.enums.OrderStatusEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PEDIDO")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TOTAL_VALUE",nullable = false)
    private Double totalValue;

    @Column(name = "STATUS",nullable = false)
    private OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID",nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;


    @OrderBy("id ASC")
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> items;


    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Order setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public Order setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Order setItems(List<OrderItem> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalValue=" + totalValue +
                ", status=" + status +
                ", restaurant=" + restaurant +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
