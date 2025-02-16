package com.rocs.video.rental.application.data.dao.item.impl;

import com.rocs.video.rental.application.data.connection.ConnectionHelper;
import com.rocs.video.rental.application.data.dao.item.ItemDao;
import com.rocs.video.rental.application.model.item.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemDaoImplTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private static MockedStatic<ConnectionHelper> connectionHelper;

    @Before
    public void setUp() throws SQLException {
        //mock connection helper
        connectionHelper = Mockito.mockStatic(ConnectionHelper.class);
        connectionHelper.when(ConnectionHelper::getConnection).thenReturn(connection);

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        doNothing().when(preparedStatement).setString(anyInt(), anyString());
        //doNothing().when(preparedStatement).setInt(anyInt(), anyInt());

        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        //when(preparedStatement.executeUpdate()).thenReturn(anyInt());

        when(resultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
    }

    @After
    public void tearDown() {
        connectionHelper.close();
    }

    @Test
    public void testFindItemById() throws SQLException {
        ItemDao itemDao = new ItemDaoImpl();
        Item item = itemDao.findItemById("1");

        verify(connection, times(1)).prepareStatement(anyString());
        verify(preparedStatement, times(1)).setString(anyInt(), anyString());
        verify(preparedStatement, times(1)).executeQuery();
        verify(resultSet, times(1)).next();
        assertNotNull(item);
    }

    @Test
    public void testFindAllItems() throws SQLException {
        ItemDao itemDao = new ItemDaoImpl();
        List<Item> items = itemDao.findAllItems();

        verify(connection, times(1)).prepareStatement(anyString());
        verify(preparedStatement, times(1)).executeQuery();
        verify(resultSet, times(2)).next();
        assertEquals(1, items.size());
    }

    @Test
    public void testAddItem() throws SQLException {
        Item item = new Item();
        item.setId("2");
        item.setTitle("Test Title");
        item.setGenre("Test Genre");
        item.setCopy(2);

        ItemDao itemDao = new ItemDaoImpl();
        boolean result = itemDao.addItem(item);

        verify(connection, times(1)).prepareStatement(anyString());
        verify(preparedStatement, times(3)).setString(anyInt(), anyString());
        verify(preparedStatement, times(1)).setInt(anyInt(), anyInt());
        verify(preparedStatement, times(1)).executeUpdate();
        assertTrue(result);
    }

    @Test
    public void testUpdateItem() throws SQLException {
        Item updateItem = new Item();
        updateItem.setId("2");
        updateItem.setTitle("Test Title");
        updateItem.setGenre("Test Genre");
        updateItem.setCopy(3);

        ItemDao itemDao = new ItemDaoImpl();
        itemDao.updateItem(updateItem);

        verify(connection, times(1)).prepareStatement(anyString());
        verify(preparedStatement, times(3)).setString(anyInt(), anyString());
        verify(preparedStatement, times(1)).setInt(anyInt(), anyInt());
        verify(preparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testDeleteItemById() throws SQLException {
        ItemDao itemDao = new ItemDaoImpl();
        itemDao.deleteItemById("1");

        verify(connection, times(1)).prepareStatement(anyString());
        verify(preparedStatement, times(1)).setString(anyInt(), anyString());
        verify(preparedStatement, times(1)).executeUpdate();
    }
}