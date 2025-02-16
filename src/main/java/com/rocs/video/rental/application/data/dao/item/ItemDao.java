package com.rocs.video.rental.application.data.dao.item;

import com.rocs.video.rental.application.model.item.Item;

import java.util.List;

public interface ItemDao {

    /**
     * Returns the Item with a given id.
     *
     * @param id the id of the Item.
     * @return the Item with a given id.
     * */
    Item findItemById(String id);

    List<Item> findAllItems();

    boolean addItem(Item item);

    boolean updateItem(Item item);

    boolean deleteItemById(String id);
}
