package ru.raiffeisen.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.data.entity.Cart;
import ru.raiffeisen.data.entity.Item;
import ru.raiffeisen.data.repo.CartRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public CartService() {
    }

    public List<Item> getItemsInCart(){
        Iterable<Cart>  cartDetails = cartRepository.findAll();
        List<Item> items = new ArrayList<>();

        for(Cart cart: cartDetails){
            items.add(cart.getItem());
        }

        return items;
    }
}
