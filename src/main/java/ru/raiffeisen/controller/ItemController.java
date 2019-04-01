package ru.raiffeisen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.data.ItemRepository;
import ru.raiffeisen.model.Item;

@RestController
public class ItemController {
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public Iterable<Item> items() {
        return itemRepository.findAll();
    }
}
