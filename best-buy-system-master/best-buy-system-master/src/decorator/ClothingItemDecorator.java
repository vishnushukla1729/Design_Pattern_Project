package decorator;

import iterators.OnlineStoreIterator;
import model.AbstractItem;
import model.Order;

/**
 * Created by ealexhaywood on 5/1/17.
 */
public class ClothingItemDecorator extends ReceiptDecorator {
    public ClothingItemDecorator(Receipt receipt) {
        super(receipt);
    }

    @Override
    public void printReceipt(Order order) {
        super.printReceipt(order);
        printClothingItems(order);
    }

    private void printClothingItems(Order order) {
        boolean hasClothingItems = false;

        System.out.println("*** CLOTHING ITEMS ***");
        System.out.println("ITEM\tPRICE"); // headers

        OnlineStoreIterator itr = order.getOnlineStore().getClothingItemsIterator(order.getOrderedItems());
        while (itr.hasNext()) {
            hasClothingItems = true;

            AbstractItem item = itr.next();
            System.out.println(item.getName() + "\t$" + item.getPrice());
        }

        // If it doesn't have clothing items, print that it has none
        if (!hasClothingItems) {
            System.out.println("<none>\tN/A");
        }

        System.out.println();
    }
}
