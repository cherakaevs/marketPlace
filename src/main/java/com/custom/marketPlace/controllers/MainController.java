package com.custom.marketPlace.controllers;

import com.custom.marketPlace.enums.OrderStatus;
import com.custom.marketPlace.model.*;
import com.custom.marketPlace.repo.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    IRepository<Order> orderIRepository;
    @Autowired
    IRepository<Category> categoryIRepository;

    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        return "home";
    }

    @GetMapping("/orders/add")
    public String createOrder(Model model){
        return "createOrder";
    }

    @PostMapping("/orders/add")
    public void createOrder(@RequestParam List<Product> products, @RequestParam Address address){
        Double sumPrice = 0.0;
        for (Product item:
              products) {
            sumPrice += item.getPrice();
        }
        Order newOrder = Order.builder().status(OrderStatus.CONFIRMED)
                                        .products(products)
                                        .sumPrice(sumPrice)
                                        .address(address)
                                        .build();
        orderIRepository.save(newOrder);
    }

    @GetMapping("/admin/categories/add")
    public String createCategory(Model model){
        return "createCategory";
    }

    public void createCategory(@RequestParam String name){
        Category category = Category.builder().name(name).build();
        categoryIRepository.save(category);
    }


}
