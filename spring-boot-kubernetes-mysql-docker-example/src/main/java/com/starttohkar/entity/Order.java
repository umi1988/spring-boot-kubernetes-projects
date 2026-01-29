package com.starttohkar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders_tbl")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer qty;
    private double price;
}
