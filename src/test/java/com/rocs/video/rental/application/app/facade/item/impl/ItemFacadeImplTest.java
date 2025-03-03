package com.rocs.video.rental.application.app.facade.item.impl;

import com.rocs.video.rental.application.app.facade.item.ItemFacade;
import com.rocs.video.rental.application.model.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ItemFacadeImplTest {

    @Mock
    private ItemFacade itemFacade;

    private List<Item> itemList;

    @BeforeEach
    public void setup() {
        itemList = new ArrayList<>();
        Item item = new Item();
        item.setId("1");
        item.setTitle("Test Title");
        item.setGenre("Test Genre");
        item.setCopy(2);
        itemList.add(item);
    }

    @Test
    public void testGetItemById() {

        when(itemFacade.getItemById(anyString())).thenReturn(itemList.get(0));

        Item itemToFind = itemFacade.getItemById("1");

        assertEquals("1", itemToFind.getId());
        assertEquals("Test Title", itemToFind.getTitle());
        assertEquals("Test Genre", itemToFind.getGenre());
        assertEquals(2, itemToFind.getCopy());
    }

    @Test
    public void testFindAllItems() {
        Item item = new Item();
        item.setId("2");
        item.setTitle("Test Title 2");
        item.setGenre("Test Genre 2");
        item.setCopy(3);
        itemList.add(item);

        when(itemFacade.getAllItems()).thenReturn(itemList);

        List<Item> itemsToFind = itemFacade.getAllItems();

        assertEquals(2, itemsToFind.size());
    }

    @Test
    public void testAddItem() {
        Item item = new Item();
        item.setId("2");
        item.setTitle("Test Title 2");
        item.setGenre("Test Genre 2");
        item.setCopy(3);

        itemFacade.addItem(item);

        verify(itemFacade, times(1)).addItem(any(Item.class));
    }

    @Test
    public void testUpdateItem() {
        Item item = new Item();
        item.setId("2");
        item.setTitle("Test Title 2");
        item.setGenre("Test Genre 2");
        item.setCopy(3);

        itemFacade.updateItem(item);

        verify(itemFacade, times(1)).updateItem(any(Item.class));
    }

    @Test
    public void testDeleteItemById() {
        itemFacade.deleteItemById("2");

        verify(itemFacade, times(1)).deleteItemById(anyString());
    }


}
