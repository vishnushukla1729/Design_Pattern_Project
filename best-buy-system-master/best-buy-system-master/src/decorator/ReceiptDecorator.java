package decorator;

import model.Order;

import java.io.Serializable;

/**
 * Abstract receipt decorate class.  To be extended by decorators
 *
 * Created by ealexhaywood on 4/30/17.
 */
public abstract class ReceiptDecorator implements Receipt, Serializable {
    protected Receipt receipt;

    public ReceiptDecorator(Receipt receipt) {
        this.receipt = receipt;
    }

    public void printReceipt(Order order) {
        receipt.printReceipt(order);
    }
}
