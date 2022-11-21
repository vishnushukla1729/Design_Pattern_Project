package decorator;

import iterators.OnlineStoreIterator;
import model.AbstractItem;
import model.Order;

/**
 * Created by ealexhaywood on 5/1/17.
 */
public class ElectronicItemDecorator extends ReceiptDecorator {
    public ElectronicItemDecorator(Receipt receipt) {
        super(receipt);
    }

    @Override
    public void printReceipt(Order order) {
        super.printReceipt(order);
        printElectronicItems(order);
    }

    private void printElectronicItems(Order order) {
        boolean hasElectronicItems = false;

        System.out.println("*** ELECTRONIC ITEMS ***");
        System.out.println("ITEM\tPRICE"); // headers

        OnlineStoreIterator itr = order.getOnlineStore().getElectronicItemsIterator(order.getOrderedItems());

        while (itr.hasNext()) {
            hasElectronicItems = true;

            AbstractItem item = itr.next();
            System.out.println(item.getName() + "\t$" + item.getPrice());
        }

        // If it doesn't have electronic items, print that it has none
        if (!hasElectronicItems) {
            System.out.println("<none>\tN/A");
        }

        System.out.println();
    }
}
