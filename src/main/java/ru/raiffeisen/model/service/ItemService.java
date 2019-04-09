package ru.raiffeisen.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.data.repo.ItemRepository;
import ru.raiffeisen.data.entity.Item;

import java.util.Optional;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item getItemByStringId(String stringId){
        long itemId = 0L;
        try {
            itemId = Long.parseLong(stringId);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return null;
        }

        Optional<Item> optionalItem = itemRepository.findById(itemId);

        if(optionalItem.isPresent()){
            return optionalItem.get();
        } else {
            return null;
        }
    }

    public Iterable<Item> findAllByCategoryId(String categoryId){
        long category = 0L;
        try {
            category = Long.parseLong(categoryId);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return null;
        }

        return itemRepository.findAllByCategoryId(category);
    }
}
