package ru.raiffeisen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.data.entity.Cart;
import ru.raiffeisen.data.repo.CartRepository;
import ru.raiffeisen.model.service.CartService;

@RestController
public class CartController {
    private CartRepository cartRepository;
    @Autowired
    private CartService cartService;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("/cartitems")
    public Iterable<Cart> itemsInCart() {
        return cartRepository.findAll();
    }
}
