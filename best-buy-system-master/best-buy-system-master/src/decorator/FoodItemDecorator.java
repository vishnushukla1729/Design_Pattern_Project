package decorator;

import iterators.OnlineStoreIterator;
import model.AbstractItem;
import model.Order;

/**
 * Created by ealexhaywood on 5/1/17.
 */
public class FoodItemDecorator extends ReceiptDecorator {
    public FoodItemDecorator(Receipt receipt) {
        super(receipt);
    }

    @Override
    public void printReceipt(Order order) {
        super.printReceipt(order);
        printFoodItems(order);
    }

    private void printFoodItems(Order order) {
        boolean hasFoodItems = false;

        System.out.println("*** FOOD ITEMS ***");
        System.out.println("ITEM\tPRICE"); // headers

        OnlineStoreIterator itr = order.getOnlineStore().getFoodItemsIterator(order.getOrderedItems());

        while (itr.hasNext()) {
            hasFoodItems = true;

            AbstractItem item = itr.next();
            System.out.println(item.getName() + "\t$" + item.getPrice());
        }

        // If it doesn't have food items, print that it has none
        if (!hasFoodItems) {
            System.out.println("<none>\tN/A");
        }

        System.out.println();
    }
}
