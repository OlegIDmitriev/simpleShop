package ru.raiffeisen.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Item item;
    //private long userId;


    public Cart() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", item=" + item +
                '}';
    }
}
