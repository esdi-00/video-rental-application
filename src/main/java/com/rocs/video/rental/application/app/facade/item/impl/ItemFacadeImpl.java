package com.rocs.video.rental.application.app.facade.item.impl;

import com.rocs.video.rental.application.app.facade.item.ItemFacade;
import com.rocs.video.rental.application.data.dao.item.ItemDao;
import com.rocs.video.rental.application.data.dao.item.impl.ItemDaoImpl;
import com.rocs.video.rental.application.model.item.Item;

import java.util.List;

public class ItemFacadeImpl implements ItemFacade {

    /** The data access object for Item. */
    private ItemDao itemDao = new ItemDaoImpl();

    @Override
    public Item getItemById(String id) {
        Item item = this.itemDao.findItemById(id);
        return item;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = this.itemDao.findAllItems();
        return itemList;
    }

    @Override
    public boolean addItem(Item item) {
        return this.itemDao.addItem(item);
    }

    @Override
    public boolean updateItem(Item item) {
        return this.itemDao.updateItem(item);
    }

    @Override
    public boolean deleteItemById(String id) {
        return this.itemDao.deleteItemById(id);
    }
}
