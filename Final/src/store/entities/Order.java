package store.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private static int autoId;
    private int id;
    private Map<Integer, Integer> productsCart;
    private String buyer;
    private BigDecimal totalPrice;
    private String orderStatus;
    private LocalDateTime orderDate;
    private String shippingAddress;

    public Order(Map<Integer, Integer> productsCart, String buyer, BigDecimal totalPrice, LocalDateTime orderDate, String shippingAddress) {
        this.id = ++autoId;
        this.productsCart = productsCart;
        this.buyer = buyer;
        this.totalPrice = totalPrice;
        this.orderStatus = "Chờ xử lý, Chưa thanh toán";
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, Integer> getProductsCart() {
        return productsCart;
    }

    public void setProductsCart(Map<Integer, Integer> productsCart) {
        this.productsCart = productsCart;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
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
        return "\n" + "Order{" +
                "id=" + id +
                ", productsCart=" + productsCart +
                ", buyer='" + buyer + '\'' +
                ", totalPrice=" + totalPrice +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDate=" + orderDate +
                ", shippingAddress='" + shippingAddress + '\'' +
                '}';
    }
}