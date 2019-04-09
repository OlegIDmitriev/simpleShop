package ru.raiffeisen.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.raiffeisen.data.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
