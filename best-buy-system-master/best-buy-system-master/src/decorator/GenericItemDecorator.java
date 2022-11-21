package decorator;

import iterators.OnlineStoreIterator;
import model.AbstractItem;
import model.Order;

/**
 * Created by ealexhaywood on 5/1/17.
 */
public class GenericItemDecorator extends ReceiptDecorator {
    public GenericItemDecorator(Receipt receipt) {
        super(receipt);
    }

    @Override
    public void printReceipt(Order order) {
        super.printReceipt(order);
        printGenericItems(order);
    }

    private void printGenericItems(Order order) {
        boolean hasGenericItems = false;

        System.out.println("*** GENERIC ITEMS ***");
        System.out.println("ITEM\tPRICE"); // headers

        OnlineStoreIterator itr = order.getOnlineStore().getGenericItemsIterator(order.getOrderedItems());

        while (itr.hasNext()) {
            hasGenericItems = true;

            AbstractItem item = itr.next();
            System.out.println(item.getName() + "\t$" + item.getPrice());
        }

        // If it doesn't have generic items, print that it has none
        if (!hasGenericItems) {
            System.out.println("<none>\tN/A");
        }

        System.out.println();
    }
}
