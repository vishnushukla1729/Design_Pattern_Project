import system.SystemInterface;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class UserInterface {

    public static void main(String[] args) {
        // Initialize a new invoker with a new aggregator
        SystemInterface.initialize();

        // initialize the store with items
        SystemInterface.initializeOnlineStore();

        Scanner scanner = new Scanner(System.in);
        boolean promptUser = true;

        userLogin();
        System.out.println("Logged in as:  " + SystemInterface.getUser());

        do {
            displayOptions();
            System.out.print("Enter in choice: ");

            try {
                int choice = scanner.nextInt();

                int itemNumber;
                switch (choice) {

                    // display
                    case 1:
                        SystemInterface.displayItemsInStore();
                        break;

                    // add
                    case 2:
                        System.out.print("Enter in item number to add: ");
                        itemNumber = scanner.nextInt();
                        String addedItem = SystemInterface.addItem(itemNumber - 1);
                        System.out.println("Item " + addedItem + " was successfully added!");
                        break;

                    // remove
                    case 3:
                        printCartItems(SystemInterface.getCartItems());
                        System.out.print("Enter in cart item number to remove: ");
                        itemNumber = scanner.nextInt();
                        String removedItem = SystemInterface.removeItem(itemNumber - 1);
                        System.out.println("Item " + removedItem + " was successfully removed from cart!");
                        break;

                    // display shopping cart items
                    case 4:
                        printCartItems(SystemInterface.getCartItems());
                        break;

                    // checkout, print receipt
                    case 5:
                        checkoutProcess();
                        System.out.println("Your shopping cart has been emptied and is ready for another order!");
                        SystemInterface.initialize();
                        break;

                    // undo previous action
                    case 6:
                        SystemInterface.undo();
                        break;

                    // exit
                    case 0:
                        System.out.println("Exiting...");
                        promptUser = false;
                        break;

                    // invalid/other choices
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Your choice was not a number!");
                scanner.next(); // consume the invalid token
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Item number doesn't exist!");
                scanner.next(); // consume the invalid token
            }
        } while (promptUser);
    }

    private static void userLogin() {
        Scanner scanner = new Scanner(System.in);

        boolean promptUser = true;
        do {
            displayUsers();
            System.out.print("Enter in choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    // login as Joe Flacco (MD Customer)
                    case 1:
                        SystemInterface.loginAsJoe();
                        promptUser = false;
                        break;
                    // login as Prime customer
                    case 2:
                        SystemInterface.loginAsPrime();
                        promptUser = false;
                        break;
                    // login as DE customer
                    case 3:
                        SystemInterface.loginAsDelaware();
                        promptUser = false;
                        break;
                    // login as NY customer
                    case 4:
                        SystemInterface.loginAsNY();
                        promptUser = false;
                        break;

                    // invalid/other choices
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }


            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Your choice was not a number!");
                scanner.next(); // consume the invalid token
            }


        } while (promptUser);
    }

    private static void displayUsers() {
        System.out.println();
        System.out.println("Users Menu");
        System.out.println("1 - Meghal's Menu");
        System.out.println("2 - Mamta's Menu");
        System.out.println("3 - Kapil's Menu");
        System.out.println("4 - Vishnu's Menu");
        System.out.println();
    }

    private static void checkoutProcess() {
        if (SystemInterface.getCartItems() == null || SystemInterface.getCartItems().size() == 0) {
            System.out.println("Nothing to check out.  You have no items in your cart.");
        } else {

            System.out.print("Would you like to add First Class shipping to this package (y/n)?");
            Scanner scanner = new Scanner(System.in);
            String wantsFirstClass = scanner.next();
            if (wantsFirstClass.equalsIgnoreCase("y")) {
                SystemInterface.setFirstClass();
            }

            // create order object
            SystemInterface.createOrder();

            // print basic receipt
            SystemInterface.printSimpleReceipt("basic");

            System.out.print("Would you like to see a more detailed receipt (y/n)? ");
            String wantsReceipt = scanner.next();

            if (wantsReceipt.equalsIgnoreCase("y")) {
                boolean promptUser = true;
                do {
                    displayReceiptOptions();
                    System.out.print("Enter in choice: ");

                    try {
                        int choice = scanner.nextInt();

                        switch (choice) {

                            case 1:
                                SystemInterface.printSimpleReceipt("all");
                                break;
                            case 2:
                                SystemInterface.printSimpleReceipt("clothing");
                                break;
                            case 3:
                                SystemInterface.printSimpleReceipt("electronic");
                                break;
                            case 4:
                                SystemInterface.printSimpleReceipt("food");
                                break;
                            case 5:
                                SystemInterface.printSimpleReceipt("generic");
                                break;

                            // exit
                            case 0:
                                System.out.println("Your order has been placed!");
                                promptUser = false;
                                break;

                            // invalid/other choices
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }

                    } catch (InputMismatchException | NumberFormatException e) {
                        System.out.println("Your choice was not a number!");
                        scanner.next(); // consume the invalid token
                    }

                } while (promptUser);
            }

        }
    }

    private static void displayReceiptOptions() {
        System.out.println();
        System.out.println("Receipt Menu");
        System.out.println("1 - Decorate with all items");
        System.out.println("2 - Decorate with clothing items");
        System.out.println("3 - Decorate with electronic items");
        System.out.println("4 - Decorate with food items");
        System.out.println("5 - Decorate with generic items");
        System.out.println("0 - Purchase and exit");
        System.out.println();
    }

    private static void printCartItems(List<String> shoppingCart) {
        System.out.println("*** ITEMS IN YOUR CART ***");

        int count = 1;
        for (String item : shoppingCart) {
            System.out.println("Cart Item #" + (count++) + ": " + item);
        }

        System.out.println();
    }

    private static void displayOptions() {
        System.out.println();
        System.out.println("Main menu");
        System.out.println("1 - Display items in store"); // Use iterator design pattern
        System.out.println("2 - Add item to cart"); // command
        System.out.println("3 - Remove item from cart"); // command
        System.out.println("4 - Display items in cart"); // command
        System.out.println("5 - Checkout"); // using command, decorater, strategy patterns
        System.out.println("6 - Undo"); // Memento
        System.out.println("0 - Exit");
        System.out.println();
    }
}
