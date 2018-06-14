package base;

import models.base.Item;

import java.util.ArrayList;

public interface Data {
    void addItem(Item item);

    ArrayList<Item> getItems();
}
