package ru.raiffeisen.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.data.repo.CategoryRepository;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


}
