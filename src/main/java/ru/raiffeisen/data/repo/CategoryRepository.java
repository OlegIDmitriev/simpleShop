package ru.raiffeisen.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.raiffeisen.data.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long > {
    Iterable<Category> findAllByOrderByIdAsc();
}
