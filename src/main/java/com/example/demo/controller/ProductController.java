package com.example.demo.controller;

import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.findAllSort());

        return "products";
    }
}

