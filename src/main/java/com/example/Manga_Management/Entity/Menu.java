package com.example.Manga_Management.Entity;

import jakarta.persistence.*;



@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String Name;

    @Column(name = "price")
    private String Price;

    @Column(name = "stock")
    private String Stock;

    public Menu() {

    }

    public Menu(String Name, String Price, String Stock) {
        super();
        this.Name = Name;
        this.Price = Price;
        this.Stock = Stock;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getPrice() {
        return Price;
    }
    public void setPrice(String Price) {
        this.Price = Price;
    }
    public String getStock() {
        return Stock;
    }
    public void setStock(String Stock) {
        this.Stock = Stock;
    }
}
