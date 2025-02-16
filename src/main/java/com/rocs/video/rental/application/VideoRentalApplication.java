package com.rocs.video.rental.application;

import com.rocs.video.rental.application.app.facade.item.ItemFacade;
import com.rocs.video.rental.application.app.facade.item.impl.ItemFacadeImpl;
import com.rocs.video.rental.application.model.item.Item;

import java.util.List;
import java.util.Scanner;

/**
 * A text based desktop application for Video Rental shops.
 */
public class VideoRentalApplication {

    public static void main(String[] args) {

        ItemFacade itemFacade = new ItemFacadeImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Video Rental System...");
        System.out.println("Please enter your selection:");
        System.out.println("1. Video Rental Item Maintenance");
        System.out.println("2. Customer Maintenance");
        System.out.println("3. Rent");
        System.out.println("4. Return");
        System.out.println("Press other keys to exit.");
        System.out.print("Enter you choice: ");
        int input = sc.nextInt();

        switch(input) {
            case 1: {
                System.out.println("Video Rental Item Maintenance");
                System.out.println("Please select an option:");
                System.out.println("1. Display all items");
                System.out.println("2. Search for an item");
                System.out.println("3. Add an item");
                System.out.println("4. Update an item");
                System.out.println("5. Delete an item");
                System.out.print("Enter you choice: ");
                int choice = sc.nextInt();

                switch(choice) {
                    case 1: {
                        List<Item> items = itemFacade.getAllItems();

                        if(items.isEmpty()) {
                            System.out.println("The list of items is empty.");
                        } else {
                            System.out.println("List of items:");
                            for(Item item: items) {
                                System.out.println(item.getTitle());
                            }
                        }
                        break;
                    }
                    case 2: {
                        //Workaround for catching nextInt
                        sc.nextLine();

                        System.out.println("Enter the id of the item to search: ");
                        String id = sc.nextLine();
                        Item item = itemFacade.getItemById(id);

                        if(item != null) {
                            System.out.println("Item found: " + item.getTitle() + " " + item.getGenre());
                        } else {
                            System.out.println("No item found.");
                        }
                        break;
                    }
                    case 3: {
                        //Workaround for catching nextInt
                        sc.nextLine();

                        System.out.println("Adding an item");
                        System.out.println("Enter item id: ");
                        String id = sc.nextLine();
                        System.out.println("Enter item title: ");
                        String title = sc.nextLine();
                        System.out.println("Enter item genre: ");
                        String genre = sc.nextLine();
                        System.out.println("Enter number of copies: ");
                        int copies = sc.nextInt();

                        Item item = new Item();
                        item.setId(id);
                        item.setTitle(title);
                        item.setGenre(genre);
                        item.setCopy(copies);

                        boolean result = itemFacade.addItem(item);

                        if(result) {
                            System.out.println("Item successfully added.");
                        } else {
                            System.out.println("Item cannot be added.");
                        }

                        break;
                    }
                    case 4: {
                        //Workaround for catching nextInt
                        sc.nextLine();

                        System.out.print("Enter the id of the item to update: ");
                        String id = sc.nextLine();

                        Item item = itemFacade.getItemById(id);
                        if(item == null) {
                            System.out.println("Item to update not found.");
                        } else {
                            System.out.println("Updating an item");
                            System.out.println("Enter item title: ");
                            String title = sc.nextLine();
                            System.out.println("Enter item genre: ");
                            String genre = sc.nextLine();
                            System.out.println("Enter number of copies: ");
                            int copies = sc.nextInt();

                            Item updateItem = new Item();
                            updateItem.setId(id);
                            updateItem.setTitle(title);
                            updateItem.setGenre(genre);
                            updateItem.setCopy(copies);

                            boolean result = itemFacade.updateItem(updateItem);

                            if(result) {
                                System.out.println("Item successfully updated.");
                            } else {
                                System.out.println("Item cannot be updated.");
                            }
                        }
                        break;
                    }
                    case 5: {
                        //Workaround for catching nextInt
                        sc.nextLine();

                        System.out.print("Enter the id of the item to delete: ");
                        String id = sc.nextLine();

                        Item item = itemFacade.getItemById(id);
                        if(item == null) {
                            System.out.println("Item to delete not found.");
                        } else {
                            boolean result = itemFacade.deleteItemById(id);

                            if(result) {
                                System.out.println("Item successfully deleted.");
                            } else {
                                System.out.println("Item cannot be deleted.");
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }

        System.out.println("Quitting the application...");

    }
}
