package com.example.demo.services;

import com.example.demo.model.OrderItem;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.LocalTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<OrderItem> getAll() {
        List<OrderItem> list = orderRepository.findAll();
        for (OrderItem o : list) {
            LocalTime currentTime = o.getTime();
            LocalTime localTime = LocalTime.now();
            if (currentTime.getMinute() >= 29) {
                if (localTime.getMinute() >= 0 && localTime.getMinute() <= 20) {
                    if (currentTime.getMinute() - 10 <= localTime.getMinute() + 40) {
                        o.setAfterTime(true);
                    }
                } else {
                    if (currentTime.getMinute() - 10 <= localTime.getMinute() - 20) {
                        o.setAfterTime(true);
                    }
                }
            }
             else {
                if (currentTime.getMinute() + 10 <= localTime.getMinute()) {
                    o.setAfterTime(true);
                }
            }
            orderRepository.save(o);
        }
        return list;
    }

    public void save(OrderItem orderItem) {
        LocalTime localTime = LocalTime.now();
        int price = 0;
        orderItem.setTime(localTime);
        if (orderItem.getItem().equals("Phone")) {
            Product p = productRepository.findProductByName("Phone");
            price = orderItem.getQuantity() * p.getPrice();
        } else if (orderItem.getItem().equals("Tv")) {
            Product p = productRepository.findProductByName("Tv");
            price = orderItem.getQuantity() * p.getPrice();
        } else if (orderItem.getItem().equals("Notebook")) {
            Product p = productRepository.findProductByName("Notebook");
            price = orderItem.getQuantity() * p.getPrice();
        }
        orderItem.setPrice(price);
        orderRepository.save(orderItem);
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }
}
