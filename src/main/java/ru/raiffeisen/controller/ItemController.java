package ru.raiffeisen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.data.repo.ItemRepository;
import ru.raiffeisen.data.entity.Item;
import ru.raiffeisen.model.service.ItemService;

@RestController
public class ItemController {
    private ItemRepository itemRepository;
    @Autowired
    private ItemService itemService;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public Iterable<Item> items() {
        return itemRepository.findAll();
    }

    @GetMapping({"/itemscat"})
    public Iterable<Item> itemsByCategory(@RequestParam(value = "category") String category) {
        return itemService.findAllByCategoryId(category);
    }
}
