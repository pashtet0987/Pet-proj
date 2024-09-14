package org.example.petproj.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.example.petproj.utils.CurrentSessionGetter;
import org.example.petproj.utils.DateParser;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Pattern(regexp = "[а-яА-Я0-9%\\-_ ]+", message = "Имя не дожно содержать символов кроме русских букв и пробелов")
    private String name;

    @Column(name = "price")
    @Min(value = 1, message = "Введите положительное число")
    private int price;

    @Column(name = "currencyName")
    private String currencyName;

    @Column(name = "rub_price")
    private Double rub_price;

    @Column(name = "date")
    private String date;

    @Column(name="amount")
    @Min(value = 1, message = "Введите положительное целое число")
    private int amount;

    @Column(name="action_performer_number")
    private String action_performer_number;

    @PrePersist
    public void prepersist(){
        action_performer_number = CurrentSessionGetter.getCurrentSession().getPhoneNumber();
        date = DateParser.getLocalDate();
    }

    public Material(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Double getRub_price() {
        return rub_price;
    }

    public void setRub_price(Double rub_price) {
        this.rub_price = rub_price;
    }

    public String getAction_performer_number() {
        return action_performer_number;
    }

    public void setAction_performer_number(String action_performer_number) {
        this.action_performer_number = action_performer_number;
    }
}
