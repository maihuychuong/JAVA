package store.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int autoId;
    private int id;
    private Product product;
    private User buyer;
    private User seller;
    private int quantity;
    private double totalPrice;
    private String orderStatus;
    private LocalDateTime orderDate;
    private String shippingAddress;

    public Order(Product product, User buyer, User seller, int quantity, double totalPrice, LocalDateTime orderDate, String shippingAddress) {
        this.id = ++autoId;
        this.product = product;
        this.buyer = buyer;
        this.seller = seller;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderStatus = "Chờ xác nhận";
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDate=" + orderDate +
                ", shippingAddress='" + shippingAddress + '\'' +
                '}';
    }
}
