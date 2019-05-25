package com.example.dwiprasetya.smartrefrige.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Transactions implements Serializable {
    String date;

    @SerializedName("item")
    List<Item> items;

    public Transactions(String date, List<Item> items) {
        this.date = date;
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
