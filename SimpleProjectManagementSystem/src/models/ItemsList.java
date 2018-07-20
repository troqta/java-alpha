package models;

import base.Data;
import models.base.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsList implements Data {
    private ArrayList<Item> items;

    public ItemsList() {
        items = new ArrayList<>();
    }

    @Override
    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }
}
