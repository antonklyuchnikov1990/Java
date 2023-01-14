package de.telran.shop.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    private String id;

    private String product;

    private LocalDateTime created;

    private LocalDateTime modified;

    private String status;

    private double sum;

}
