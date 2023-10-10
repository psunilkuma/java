This is a java based appliaction

import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return menuItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return menuItem.getName() + " x" + quantity + ": $" + getTotalPrice();
    }
}

class Cafe {
    private ArrayList<MenuItem> menu;
    private ArrayList<OrderItem> orders;

    public Cafe() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        menu.add(new MenuItem(name, price));
        System.out.println("Menu item added: " + name + " ($" + price + ")");
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (MenuItem item : menu) {
            System.out.println(item.getName() + ": $" + item.getPrice());
        }
    }

    public void takeOrder(String itemName, int quantity) {
        MenuItem menuItem = findMenuItem(itemName);
        if (menuItem != null) {
            orders.add(new OrderItem(menuItem, quantity));
            System.out.println("Order added: " + itemName + " x" + quantity);
        } else {
            System.out.println("Menu item not found.");
        }
    }

    public void displayOrders() {
        System.out.println("Current Orders:");
        double totalBill = 0;
        for (OrderItem orderItem : orders) {
            System.out.println(orderItem.toString());
            totalBill += orderItem.getTotalPrice();
        }
        System.out.println("Total Bill: $" + totalBill);
    }

    private MenuItem findMenuItem(String itemName) {
        for (MenuItem menuItem : menu) {
            if (menuItem.getName().equalsIgnoreCase(itemName)) {
                return menuItem;
            }
        }
        return null;
    }
}

public class CafeApplication {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCafe Application Menu:");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Display Menu");
            System.out.println("3. Take Order");
            System.out.println("4. Display Orders");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (

