package ru.raiffeisen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.raiffeisen.data.ItemRepository;
import ru.raiffeisen.model.Item;

@Controller
public class MainController {

    @GetMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping({"/main"})
    public String main(Model model) {
        return "main";
    }
}

