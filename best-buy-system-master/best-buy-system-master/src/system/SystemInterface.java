package system;

import command.Aggregator;
import command.Invoker;
import iterators.OnlineStoreIterator;
import memento.Originator;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by ealexhaywood on 4/15/17.
 */
public class SystemInterface {

    private static Invoker invoker;
    private static OnlineStore onlineStore;
    private static User user;

    // Mementos
    private static Stack<Originator.Memento> savedStates = new Stack<>();
    private static Originator originator = new Originator();

    public static String addItem(int index) {
        originator.set(invoker.getAggregator());
        savedStates.push(originator.saveToMemento());
        AbstractItem abstractItem = invoker.addItem(onlineStore.getInventory().get(index));
        return abstractItem.toString();
    }

    public static String removeItem(int index) {
        originator.set(invoker.getAggregator());
        savedStates.push(originator.saveToMemento());
        AbstractItem abstractItem = invoker.removeItem(invoker.getAggregator().getAll().get(index));
        return abstractItem.toString();
    }

    public static List<String> getCartItems() {
        return invoker.getItems().stream().map(item -> item.toString()).collect(Collectors.toList()); // Java 8 just for fun :P
    }

    public static void printSimpleReceipt(String type) {
        originator.set(invoker.getAggregator());
        savedStates.push(originator.saveToMemento());
        invoker.printSimpleReceipt(type);
    }

    public static void createOrder() {
        originator.set(invoker.getAggregator());
        savedStates.push(originator.saveToMemento());
        invoker.createOrder(user);
    }

    public static void displayItemsInStore() {
        System.out.println();
        System.out.println("***DISPLAYING ITEMS IN STORE***");
        OnlineStoreIterator itr = onlineStore.getAllItemsIterator();

        int count = 1;
        while (itr.hasNext()) {
            System.out.println("Item #" + (count++) + ": " + itr.next().toString());
        }

        System.out.println();
    }

    public static void undo() {
        if (savedStates.size() > 0) {
            invoker.setAggregator(originator.restoreFromMemento(savedStates.pop()));
            System.out.println("Your last action has been undone!  Any items, receipts, or orders " +
                    "have been restored to their previous state");
        } else {
            System.out.println("Nothing to undo. No previous states saved");
        }
    }

    public static void initializeOnlineStore() {
        onlineStore = OnlineStore.getInstance();
        List<AbstractItem> inventory = new ArrayList<>();
        inventory.add(new ElectronicItem("iPhone 7", 699.00, ElectronicItemType.CELL_PHONE, "720p", 5.0));
        inventory.add(new ElectronicItem("Surface Pro", 399.99, ElectronicItemType.LAPTOP, "1080p", 15.0));
        inventory.add(new ClothingItem("Affliction T-Shirt", 39.99, ClothingItemType.SHIRT, "Large", false));
        inventory.add(new ClothingItem("Spongebob Pants", 12.49, ClothingItemType.PANTS, "Medium", true));
        inventory.add(new FoodItem("Frozen T-Bone Steak 6-Pack", 45.99, FoodItemType.MEAT, false));
        inventory.add(new FoodItem("Fresh Spinach", 6.00, FoodItemType.VEGETABLES, true));
        inventory.add(new GenericItem("Towels", 15.99));
        inventory.add(new GenericItem("Bed Sheets", 29.99));
        inventory.add(new ElectronicItem("iPhone 7", 699.00, ElectronicItemType.CELL_PHONE, "720p", 5.0));
        inventory.add(new ElectronicItem("Surface Pro", 399.99, ElectronicItemType.LAPTOP, "1080p", 15.0));
        inventory.add(new ElectronicItem("HP Computer Super Bundle", 899.00, ElectronicItemType.DESKTOP_PC, "10800p", 24.0));
        inventory.add(new ElectronicItem("ASUS GHS417", 299.99, ElectronicItemType.LAPTOP, "720p", 17.0));
        inventory.add(new ElectronicItem("HP w/ broken disc bay", 249.99, ElectronicItemType.CELL_PHONE, "720p", 17.0));
        inventory.add(new ClothingItem("Itchy-And-Scratchy T-Shirt", 19.99, ClothingItemType.SHIRT, "Small", true));
        inventory.add(new ClothingItem("Hardcore Pants", 32.49, ClothingItemType.PANTS, "Medium", false));
        inventory.add(new ClothingItem("Fresh Jordans", 229.99, ClothingItemType.SHOES, "10", false));
        inventory.add(new ClothingItem("Hospital Shoes", 32.49, ClothingItemType.SHOES, "12", false));
        inventory.add(new ClothingItem("Affliction T-Shirt", 39.99, ClothingItemType.SHIRT, "Large", false));
        inventory.add(new ClothingItem("Spongebob Pants", 12.49, ClothingItemType.PANTS, "Medium", true));
        inventory.add(new ClothingItem("Ugly Xmas Sweater", 24.99, ClothingItemType.SHIRT, "Medium", true));
        inventory.add(new ClothingItem("Board Shorts", 32.49, ClothingItemType.PANTS, "Large", false));
        inventory.add(new ClothingItem("Samurai Sandles", 9.99, ClothingItemType.SHOES, "15", false));
        inventory.add(new ClothingItem("Bob-It! Shoes", 44.99, ClothingItemType.SHOES, "6", true));
        inventory.add(new ClothingItem("Corny T-Shirt", 19.99, ClothingItemType.SHIRT, "Small", false));
        inventory.add(new ClothingItem("Shiny Disco Pants", 28.60, ClothingItemType.PANTS, "Medium", false));
        inventory.add(new ClothingItem("Shiny Disco Shirt", 22.60, ClothingItemType.SHIRT, "Medium", false));
        inventory.add(new ClothingItem("Shiny Disco Shoes", 42.60, ClothingItemType.SHOES, "Medium", false));
        inventory.add(new FoodItem("Shrimp Sticks", 25.99, FoodItemType.MEAT, false));
        inventory.add(new FoodItem("Apples", 5.99, FoodItemType.FRUIT, true));
        inventory.add(new FoodItem("Healthy Chew", 3.00, FoodItemType.SNACKS, true));
        inventory.add(new FoodItem("Frozen T-Bone Steak 6-Pack", 45.99, FoodItemType.MEAT, false));
        inventory.add(new FoodItem("Fresh Spinach", 6.00, FoodItemType.VEGETABLES, true));
        inventory.add(new FoodItem("Aged Spinach", 10.00, FoodItemType.VEGETABLES, true));
        inventory.add(new FoodItem("Republican Ribs", 29.99, FoodItemType.MEAT, false));
        inventory.add(new FoodItem("Melons", 7.99, FoodItemType.FRUIT, true));
        inventory.add(new FoodItem("Tasty Treats", 5.00, FoodItemType.SNACKS, true));
        inventory.add(new FoodItem("Mystery Meat", 7.99, FoodItemType.MEAT, false));
        inventory.add(new FoodItem("Ionized Lettuce", 3.00, FoodItemType.VEGETABLES, true));
        inventory.add(new FoodItem("Eagle", 50.99, FoodItemType.MEAT, false));
        inventory.add(new FoodItem("Watermelon", 8.99, FoodItemType.FRUIT, true));
        inventory.add(new FoodItem("Zionist Cakes", 10.00, FoodItemType.SNACKS, false));
        inventory.add(new FoodItem("Turtle", 10.99, FoodItemType.MEAT, false));
        inventory.add(new FoodItem("Mashed Pork", 9.99, FoodItemType.MEAT, false));
        inventory.add(new FoodItem("Tango Fruit Cups", 7.99, FoodItemType.FRUIT, true));
        inventory.add(new FoodItem("Malaised Muffins", 8.00, FoodItemType.SNACKS, true));
        inventory.add(new FoodItem("Mashed Chicken", 8.99, FoodItemType.MEAT, false));
        inventory.add(new GenericItem("Towels", 15.99));
        inventory.add(new GenericItem("Bed Sheets", 29.99));
        inventory.add(new GenericItem("Cool Pens", 5.99));
        inventory.add(new GenericItem("Lame Pens", 1.99));
        inventory.add(new GenericItem("Foo Foo's Chew Chew", 10.00));
        inventory.add(new GenericItem("Quesadilla Spatula", 9.99));
        inventory.add(new GenericItem("Magnifying Glass", 6.99));
        onlineStore.setInventory(inventory);
    }

    private static void setInvoker(Invoker invoker) {
        SystemInterface.invoker = invoker;
    }

    public static void initialize() {
        setInvoker(new Invoker(new Aggregator()));
    }

    public static void loginAsJoe() {
        user = new User("Joe Flacco", false, "Maryland",false);
    }

    public static void loginAsPrime() {
        user = new User("Optimus Prime", true, "Maryland",false);
    }

    public static void loginAsDelaware() {
        user = new User("Delaware Guy", false, "Delaware",false);
    }

    public static void loginAsNY() {
        user = new User("NY Fella", false, "New York",false);
    }

    public static String getUser() {
        return user.toString();
    }

    public static void setFirstClass(){user.setFirstClass(true);}
}
