package main.service;

import main.model.Order;
import main.model.Product;
import main.model.User;
import main.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    public Order placeOrder(User user, List<Product> products) {
        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        order.setTotalPrice(products.stream().mapToDouble(Product::getPrice).sum());
        return orderRepository.save(order);
    }
}
