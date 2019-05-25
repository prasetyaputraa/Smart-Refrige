package com.example.dwiprasetya.smartrefrige.Model;

public class Item {
    String name;
    int amount, capacity;

    public Item(String name, int amount, int capacity) {
        this.name = name;
        this.amount = amount;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
