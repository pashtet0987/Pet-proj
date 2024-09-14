package org.example.petproj.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.example.petproj.utils.CurrentSessionGetter;
import org.example.petproj.utils.DateParser;

@Entity
@Table(name="sells")
public class Sells {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "cheese_name")
    private String cheeseName;

    @Column(name = "amount_of_sells")
    @Min(value = 1, message = "Введите положительное целое число")
    private int amountOfSells;

    @Column(name = "price")
    private Double price;
    @Column(name = "date")
    private String date;

    @Column(name="action_performer_number")
    private String action_performer_number;

    @PrePersist
    public void prepersist(){
        action_performer_number = CurrentSessionGetter.getCurrentSession().getPhoneNumber();
        date = DateParser.getLocalDate();
    }

    public Sells(){}


    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public int getAmountOfSells() {
        return amountOfSells;
    }

    public void setAmountOfSells(int amountOfSells) {
        this.amountOfSells = amountOfSells;
    }

    public String getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getAction_performer_number() {
        return action_performer_number;
    }

    public void setAction_performer_number(String action_performer_number) {
        this.action_performer_number = action_performer_number;
    }
}
