package ru.raiffeisen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.data.entity.Category;
import ru.raiffeisen.data.repo.CategoryRepository;

@RestController
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public Iterable<Category> categories() {
        return categoryRepository.findAll();
    }
}
