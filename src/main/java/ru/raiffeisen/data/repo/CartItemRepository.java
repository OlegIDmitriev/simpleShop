package ru.raiffeisen.data.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.raiffeisen.data.entity.CartItem;

import java.util.Optional;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    Optional<CartItem> findByItemId(long itemId);

    Iterable<CartItem> findAllByOrderByIdAsc();

    @Query(value = "SELECT SUM(c.quantity * i.price) AS \"RESULT\" FROM cart_item c \n" +
            "JOIN item i ON c.item_id = i.id",
            nativeQuery = true)
    double getTotalPriceInCart();
}
