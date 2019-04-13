package ru.raiffeisen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.data.entity.CartItem;
import ru.raiffeisen.data.repo.CartItemRepository;
import ru.raiffeisen.model.service.CartItemService;

@RestController
public class CartItemController {
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartItemService cartItemService;

    public CartItemController(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @GetMapping("/cartitems")
    public Iterable<CartItem> itemsInCart() {
        return cartItemRepository.findAll();
    }

    @GetMapping("/cartcount")
    public long itemsCountInCart(){
        return cartItemRepository.count();
    }

    @PutMapping("/additem")
    public void addItemToCart(@RequestParam(value = "id") String itemId){
        cartItemService.addItemInCart(itemId);
    }

    @DeleteMapping("/deleteitem")
    public void removeItemFromCart(@RequestBody String itemId){
        cartItemService.removeItemFromCart(itemId);
    }

    @PostMapping("/inc")
    public void incQuantity(@RequestBody String cartItemId){
        cartItemService.incQuantity(cartItemId);
    }

    @PostMapping("/dec")
    public void decQuantity(@RequestBody String cartItemId){
        cartItemService.decQuantity(cartItemId);
    }
}
