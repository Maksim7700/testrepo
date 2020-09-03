package com.example.demo.controller;

import com.example.demo.model.OrderItem;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class MainController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getIndex(Model model, @ModelAttribute("order") OrderItem orderItem) {
        List<OrderItem> list = orderService.getAll();
        model.addAttribute("orders", list);
        return "index";
    }

    @PostMapping
    public String sendOrder(Model model, @ModelAttribute("order") OrderItem orderItem) {
        orderService.save(orderItem);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteOrder(@RequestParam("orderId") int id) {
        orderService.deleteById(id);
        return "redirect:/";
    }

}
