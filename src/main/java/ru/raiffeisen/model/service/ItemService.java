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
        long id = getLongIdFromString(stringId);

        if(id == -1)
            return null;

        Optional<Item> optionalItem = itemRepository.findById(id);

        if(optionalItem.isPresent()){
            return optionalItem.get();
        } else {
            return null;
        }
    }

    public Iterable<Item> findAllByCategoryId(String categoryId){
        long id = getLongIdFromString(categoryId);

        if(id == -1)
            return null;

        return itemRepository.findAllByCategoryId(id);
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
