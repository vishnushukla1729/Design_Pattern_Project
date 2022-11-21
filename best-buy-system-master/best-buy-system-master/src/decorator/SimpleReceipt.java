package decorator;

import model.Order;

import java.io.Serializable;

/**
 * Simple receipt
 *
 * Created by ealexhaywood on 4/30/17.
 */
public class SimpleReceipt implements Receipt, Serializable {
    @Override
    public void printReceipt(Order order) {
        System.out.println("***Printing Simple Receipt***");
        System.out.println();
        System.out.println("Order for: " + order.getUser());
        System.out.println("Order Placed: " + order.getDate());
        System.out.println("Best Buy Store order number: " + order.getOrderNumber().toString());
        System.out.println("Subtotal: $" + order.getSubTotal());
        System.out.println("Sales Tax: $" + order.getSalesTax());
        System.out.println("Shipping Cost: $" + order.getShippingCost());
        System.out.println("Grand Order Total: $" + order.getGrandTotal());
        System.out.println();
    }
}
