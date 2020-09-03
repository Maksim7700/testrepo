package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "Orders")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int price;
    private int quantity;
    private String item;


    private LocalTime time;
    @Transient
    private Boolean afterTime;


    public OrderItem(int price, int quantity, LocalTime time, String item) {
        this.price = price;
        this.quantity = quantity;
        this.time = time;
        this.item = item;
        this.setAfterTime(false);
    }

    public OrderItem(int price, int quantity, LocalTime time, String item, Boolean afterTime) {
        this.price = price;
        this.quantity = quantity;
        this.time = time;
        this.item = item;
        this.afterTime = afterTime;
    }

    public Boolean getAfterTime() {
        return afterTime;
    }

    public void setAfterTime(Boolean afterTime) {
        this.afterTime = afterTime;
    }

    public OrderItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        OrderItem order = (OrderItem) object;
        return price == order.price &&
                quantity == order.quantity &&
                Objects.equals(id, order.id) &&
                Objects.equals(item, order.item) &&
                Objects.equals(time, order.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity, item, time);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", item='" + item + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
