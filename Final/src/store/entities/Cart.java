package store.entities;

import java.util.List;
import java.util.Map;

public class Cart {
     Map<Integer, Integer> productsCart;

    public Cart(Map<Integer, Integer> productsCart) {
        this.productsCart = productsCart;
    }

    public Map<Integer, Integer> getProductsCart() {
        return productsCart;
    }

    public void setProductsCart(Map<Integer, Integer> productsCart) {
        this.productsCart = productsCart;
    }
}
