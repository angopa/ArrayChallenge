package com.andgopa.grocerystore;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();


    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        int i = 1;
        for (String s : groceryList) {
            System.out.println(i + ". " + s);
            i++;
        }
    }

    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    public void removeGroceryItem(int position) {
        groceryList.remove(position);
    }

    public String findItem(String searchItem) {
        int position = groceryList.indexOf(searchItem);
        if (position >= 0) {
            return groceryList.get(position);
        }
        return null;
    }

    public static class Main {

        private static Scanner scanner = new Scanner(System.in);

        private static GroceryList groceryList = new GroceryList();

        public static void main(String[] args) {
            boolean quit = true;
            int choice = 0;
            printInstructions();
            while(quit) {
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        printInstructions();
                        break;
                    case 1:
                        groceryList.printGroceryList();
                        break;
                    case 2:
                        addItem();
                        break;
                    case 3:
                        modifyItem();
                        break;
                    case 4:
                        removeItem();
                        break;
                    case 5:
                        searchItem();
                        break;
                    case 6:
                        quit = false;
                        break;
                }
            }
        }

        private static void printInstructions() {
            System.out.println("\nPress ");
            System.out.println("\n0 = To print choice options. ");
            System.out.println("\n1 = To print the list of grocery items. ");
            System.out.println("\n2 = To add an item to the list. ");
            System.out.println("\n3 = To modify an item in the list. ");
            System.out.println("\n4 = To remove an item from the list. ");
            System.out.println("\n5 = To search for an item in the list. ");
            System.out.println("\n6 = To quit the application. ");
        }

        private static void addItem() {
            System.out.println("Please enter the grocery item: ");
            groceryList.addGroceryItem(scanner.nextLine());
        }

        private static void modifyItem() {
            System.out.println("Please enter item number: ");
            int itemNo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter replacement item: ");
            String newItem = scanner.nextLine();
            groceryList.modifyGroceryItem(itemNo - 1, newItem);
        }

        private static void removeItem() {
            System.out.println("Enter item number: ");
            int itemNo = scanner.nextInt();
            scanner.nextLine();
            groceryList.removeGroceryItem(itemNo);
        }

        private static void searchItem() {
            System.out.println("Item to search for: ");
            String searchItem = scanner.nextLine();
            if (groceryList.findItem(searchItem) != null) {
                System.out.println("Found " + searchItem + "in our grocery list");
            } else {
                System.out.println("Item not found in our grocery list");
            }
        }
    }
}
