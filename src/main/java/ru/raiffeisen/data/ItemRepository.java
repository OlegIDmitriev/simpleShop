package ru.raiffeisen.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.raiffeisen.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long > {
}
