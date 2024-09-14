package main.controller;

import model.Order;
import main.model.User;
import main.service.OrderService;
import main.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody OrderRequest orderRequest) {
        User user = userService.getUserByUsername(orderRequest.getUsername());
        List<Product> products = orderRequest.getProducts();  // Simplified for example
        return orderService.placeOrder(user, products);
    }

    @GetMapping("/{username}")
    public List<Order> getOrdersByUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return orderService.getOrdersByUser(user);
    }
}
