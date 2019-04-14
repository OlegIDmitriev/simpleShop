package ru.raiffeisen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.data.repo.ItemRepository;
import ru.raiffeisen.data.entity.Item;
import ru.raiffeisen.model.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
    private ItemRepository itemRepository;
    @Autowired
    private ItemService itemService;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/all")
    public Iterable<Item> items() {
        return itemRepository.findAllByOrderByIdAsc();
    }

    @GetMapping({"/category"})
    public Iterable<Item> itemsByCategory(@RequestParam(value = "id") String categoryId) {
        return itemService.findAllByCategoryId(categoryId);
    }
}
