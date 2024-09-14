package main.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Many orders can belong to one user
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany // One order can contain many products
    @JoinTable(
      name = "order_products", 
      joinColumns = @JoinColumn(name = "order_id"), 
      inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Column(nullable = false)
    private double totalPrice;

    private LocalDateTime orderDate;

    // Constructors
    public Order() {}

    public Order(User user, List<Product> products, double totalPrice) {
        this.user = user;
        this.products = products;
        this.totalPrice = totalPrice;
        this.orderDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
