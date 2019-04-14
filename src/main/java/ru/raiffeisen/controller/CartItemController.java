package ru.raiffeisen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.data.entity.CartItem;
import ru.raiffeisen.data.repo.CartItemRepository;
import ru.raiffeisen.model.service.CartItemService;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartItemController {
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartItemService cartItemService;

    public CartItemController(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @GetMapping("/items")
    public Iterable<CartItem> itemsInCart() {
        return cartItemRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/count")
    public long itemsCountInCart(){
        return cartItemRepository.count();
    }

    @PutMapping("/add")
    public ResponseEntity addItemToCart(@RequestParam(value = "id") String itemId){
        cartItemService.addItemInCart(itemId);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity removeItemFromCart(@RequestParam(value = "cartItemId") String cartItemId){
        cartItemService.removeItemFromCart(cartItemId);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/inc")
    public ResponseEntity incQuantity(@RequestBody Map<String, String> json){
        String cartItemId = json.get("cartItemId");
        cartItemService.incQuantity(cartItemId);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/dec")
    public ResponseEntity decQuantity(@RequestBody Map<String, String> json){
        String cartItemId = json.get("cartItemId");
        cartItemService.decQuantity(cartItemId);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/price")
    public double getTotalPrice(){
        return cartItemRepository.getTotalPriceInCart();
    }
}
