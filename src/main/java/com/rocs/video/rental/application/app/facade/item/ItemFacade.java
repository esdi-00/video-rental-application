package com.rocs.video.rental.application.app.facade.item;

import com.rocs.video.rental.application.model.item.Item;

import java.util.List;

/**
 * An interface that manages Item object maintenance such as
 * creating new Item, updating and deleting existing items.
 * */
public interface ItemFacade {

    /**
     * Gets the item with a given id.
     *
     * @param id the id of the item
     * @return an Item with a given id.
     * */
    Item getItemById(String id);

    /**
     * Returns the list of Items.
     *
     * @return list of Items.
     * */
    List<Item> getAllItems();

    boolean addItem(Item item);

    boolean updateItem(Item item);

    boolean deleteItemById(String id);

}
