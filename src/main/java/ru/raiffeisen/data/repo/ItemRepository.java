package ru.raiffeisen.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.raiffeisen.data.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long > {
    Iterable<Item> findAllByOrderByIdAsc();

    Iterable<Item> findAllByCategoryId(long categoryId);

    Iterable<Item> findAllByCategoryIdOrderByIdAsc(long categoryId);
}
