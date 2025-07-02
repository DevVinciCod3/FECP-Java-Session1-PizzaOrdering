package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<String> pizzaTypes = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        System.out.println("\n--- Pizza Order System ---");
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");


        boolean running = true;

        while (running) {
            System.out.println();
            System.out.print("Choose option: ");
            int option = s.nextInt();

            switch (option) {
                case 1:
                {
                    s.nextLine(); // Clear newline
                    System.out.print("Pizza type: ");
                    String pizza = s.nextLine();

                    System.out.print("Quantity: ");
                    int qty = s.nextInt();

                    addOrder(pizzaTypes, quantities, pizza, qty);

                    break;
                }

                case 2:
                {
                    System.out.print("Enter order number to update: ");
                    int orderNumber = s.nextInt() - 1;

                    System.out.print("Enter new quantity: ");
                    int newQuantity = s.nextInt();

                    updateOrder(quantities, orderNumber, newQuantity);

                    break;
                }
                case 3:
                {
                    System.out.print("Enter order number to remove: ");
                    int index = s.nextInt();
                    index = index - 1;

                    removeOrder(pizzaTypes, quantities, index);

                    break;
                }
                case 4:
                {
                    printOrders(pizzaTypes, quantities);

                    break;
                }

                case 5:
                {
                    running = false;
                    System.out.println("--- Thank you! ---");

                    break;
                }

                default:
                {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        s.close();
    }

    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int qty) {
        if (qty > 0) {
            pizzas.add(pizzaType);
            quantities.add(qty);
            System.out.println("Order added: " + pizzaType + " x" + qty);
        } else {
            System.out.println("Quantity must be positive.");
        }
    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        if (index >= 0 && index < quantities.size()) {
            if (newQuantity > 0) {
                quantities.set(index, newQuantity);
                System.out.println("Order updated.");
            } else {
                System.out.println("Quantity must be positive.");
            }
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        if (index >= 0 && index < pizzas.size()) {

            System.out.println("Removing order: " + pizzas.get(index) + " x" + quantities.get(index));
            pizzas.remove(index);
            quantities.remove(index);
            System.out.println("Order removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        if (pizzas.isEmpty()) {
            System.out.println("No orders to display.");
            return;
        }

        System.out.println("\n--- Current Orders ---");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.printf("Order #%d: %s - %d%n", i + 1, pizzas.get(i), quantities.get(i));
        }
    }
}
