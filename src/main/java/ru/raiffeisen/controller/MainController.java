package ru.raiffeisen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.raiffeisen.data.entity.Item;
import ru.raiffeisen.model.service.ItemService;

@Controller
public class MainController {
    @Autowired
    private ItemService itemService;

    @GetMapping({"/hello"})
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping({"/","/main"})
    public String main(Model model) {
        return "main";
    }

    @GetMapping({"/item"})
    public String item(Model model, @RequestParam(value = "id") String id) {
        Item item = itemService.getItemByStringId(id);

        if (item == null)
            return "404";

        model.addAttribute("item", item);
        return "item";
    }

    @GetMapping({"/cart"})
    public String cart(Model model) {
        return "cart";
    }

    @GetMapping({"/info"})
    public String info(Model model) {
        return "info";
    }
}

