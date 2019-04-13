package ru.raiffeisen.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.raiffeisen.data.entity.CartItem;

import java.util.Optional;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    Optional<CartItem> findByItemId(long itemId);
}
