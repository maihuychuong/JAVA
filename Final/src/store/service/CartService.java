package store.service;

import store.entities.Product;

import java.util.List;

public class CartService {
    List<Product> productsCart;

    public CartService(List<Product> productsCart) {
        this.productsCart = productsCart;
    }

    public List<Product> getProductsCart() {
        return productsCart;
    }

    public void setProductsCart(List<Product> productsCart) {
        this.productsCart = productsCart;
    }

    @Override
    public String toString() {
        return "CartService{" +
                "productsCart=" + productsCart +
                '}';
    }
}
