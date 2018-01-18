package ru.otus.json.model;

import ru.otus.json.model.Owner;

public class Car {

    private String mark;
    private String model;
    private double price;
    private transient Owner person;

    public Car(){}

    public Car(String mark, String model, int price) {
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Owner getPerson() {
        return person;
    }

    public void setPerson(Owner person) {
        this.person = person;
    }
}
