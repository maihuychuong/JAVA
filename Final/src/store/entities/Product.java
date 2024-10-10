package store.entities;

import java.math.BigDecimal;

public class Product {
    private static int autoId;
    private int id;
    private String name;
    private BigDecimal price;
    private String description;
    private int quantity;
    private String seller;

    public Product(String name, BigDecimal price, String description, int quantity, String seller) {
        this.id = ++autoId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", seller='" + seller + '\'' +
                '}';
    }
}
