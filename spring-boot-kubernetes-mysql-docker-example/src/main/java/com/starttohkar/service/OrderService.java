package com.starttohkar.service;

import com.starttohkar.entity.Order;
import com.starttohkar.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    // No-op AutoCloseable so try-with-resources can be used without declaring checked exceptions
    private static final class NoOpResource implements AutoCloseable {
        @Override
        public void close() { /* no-op */ }
    }

//    public Order addOrder(Order order){
//        return repository.save(order);
//    }
//
//    public List<Order> getOrders(){
//        return repository.findAll();
//    }
//
//    public Order getOrderById(int id){
//        return repository.findById(id)
//                .orElseThrow(()->new IllegalArgumentException("Invalid id : "+id));
//    }

    public Order addOrder(Order order){
        try (NoOpResource r = new NoOpResource()) {
            return repository.save(order);
        }
    }

    public List<Order> getOrders(){
        try (NoOpResource r = new NoOpResource()) {
            return repository.findAll();
        }
    }

    public Order getOrderById(int id){
        try (NoOpResource r = new NoOpResource()) {
            return repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid id : " + id));
        }
    }
}
