package ru.raiffeisen.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.data.entity.CartItem;
import ru.raiffeisen.data.entity.Item;
import ru.raiffeisen.data.repo.CartItemRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ItemService itemService;

    public CartItemService() {
    }

    public void addItemInCart(String itemId){
        CartItem cartItem = findCartItemByItemId(itemId);

        if(cartItem == null){
            Item item = itemService.getItemByStringId(itemId);
            cartItem = new CartItem(item, 1);
            cartItemRepository.save(cartItem);

            return;
        }

        cartItem.incQuantity();
    }

    public void setItemQuantityInCart(String cartItemId, int quantity){
        long id = getLongIdFromString(cartItemId);

        if(id == -1)
            return;

        Optional<CartItem> optional = cartItemRepository.findById(id);

        if(optional.isPresent()) {
            optional.get().setQuantity(quantity);
        }
    }

    public void removeItemFromCart(String cartItemId){
        long id = getLongIdFromString(cartItemId);

        if(id == -1)
            return;

        cartItemRepository.deleteById(id);
    }

    public CartItem findCartItemByItemId(String itemId){
        long id = getLongIdFromString(itemId);

        if(id == -1)
            return null;

        Optional<CartItem> optional = cartItemRepository.findByItemId(id);

        if(optional.isPresent()){
            return optional.get();
        }

        return null;
    }

    public void incQuantity(String cartItemId){
        long id = getLongIdFromString(cartItemId);

        if(id == -1)
            return;

        Optional<CartItem> optional = cartItemRepository.findById(id);
        if(optional.isPresent()){
            cartItemRepository.findById(id).get().incQuantity();
        }
    }

    public void decQuantity(String cartItemId){
        long id = getLongIdFromString(cartItemId);

        if(id == -1)
            return;

        Optional<CartItem> optional = cartItemRepository.findById(id);
        if(optional.isPresent()){
            cartItemRepository.findById(id).get().decQuantity();
        }
    }

    private long getLongIdFromString(String longString){
        long id;

        try{
            id = Long.parseLong(longString);
        } catch (NumberFormatException nfe){
            nfe.printStackTrace();

            return -1;
        }

        return id;
    }
}
