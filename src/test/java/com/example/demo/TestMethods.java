package com.example.demo;

import com.example.demo.model.OrderItem;
import com.example.demo.model.Product;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestMethods {
    @Test
    public void afterTest() {
        List<OrderItem> list = new ArrayList<>();
        LocalTime l = LocalTime.of(11, 55, 34);
        OrderItem o1 = new OrderItem(600, 6, l, "Phone", false);
        OrderItem o2 = new OrderItem(600, 3, l, "Tv", false);
        OrderItem o3 = new OrderItem(300, 2, l, "Notebook", false);
        list.add(o1);
        list.add(o2);
        list.add(o3);
        for (OrderItem o : list) {
            LocalTime currentTime = o.getTime();
            LocalTime localTime = LocalTime.of(12, 5, 50);
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
            OrderItem o4 = new OrderItem(600, 6, l, "Phone");
            o4.setAfterTime(true);
            Assert.assertEquals(true, o1.getAfterTime());
        }
    }


        @Test
        public void sort () {
            List<Product> list = Lists.newArrayList(
                    new Product("Notebook", 400),
                    new Product("Tv", 200),
                    new Product("Phone", 150)
            );
            Collections.sort(list, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Integer.compare(o1.getPrice(), o2.getPrice());
                }
            });
            Assert.assertEquals(list.get(0), new Product("Phone", 150));
        }

        @Test
        public void save () {
            LocalTime localTime = LocalTime.now();
            OrderItem orderItem = new OrderItem();
            orderItem.setItem("Tv");
            orderItem.setQuantity(3);
            Product p = new Product("Tv", 200);
            int price = 0;
            orderItem.setTime(localTime);
            if (orderItem.getItem().equals("Tv")) {
                price = orderItem.getQuantity() * p.getPrice();
            }
            orderItem.setPrice(price);
            Assert.assertEquals(600, orderItem.getPrice());
        }
    }
