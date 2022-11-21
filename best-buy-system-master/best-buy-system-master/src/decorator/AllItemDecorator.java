package decorator;

import iterators.OnlineStoreIterator;
import model.AbstractItem;
import model.Order;

/**
 * Created by ealexhaywood on 5/1/17.
 */
public class AllItemDecorator extends ReceiptDecorator {
    public AllItemDecorator(Receipt receipt) {
        super(receipt);
    }

    @Override
    public void printReceipt(Order order) {
        super.printReceipt(order);
        printAllItems(order);
    }

    private void printAllItems(Order order) {
        System.out.println("*** ALL ITEMS ***");
        System.out.println("ITEM\tTYPE\tPRICE"); // headers

        OnlineStoreIterator itr = order.getOnlineStore().getAllItemsIterator(order.getOrderedItems());
        while (itr.hasNext()) {
            AbstractItem item = itr.next();
            System.out.println(item.getName() + "\t" + item.getClass().getSimpleName() + "\t$" + item.getPrice());
        }

        System.out.println();
    }
}
