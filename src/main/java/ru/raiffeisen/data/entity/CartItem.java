package ru.raiffeisen.data.entity;

import javax.persistence.*;


@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Item item;
    //private long userId;

    private int quantity;


    public CartItem() {
    }

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incQuantity(){
        quantity++;
    }

    public void decQuantity(){
        quantity--;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
