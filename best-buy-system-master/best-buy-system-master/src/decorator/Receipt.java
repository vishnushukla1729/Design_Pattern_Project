package decorator;

import model.Order;

/**
 * Created by ealexhaywood on 4/30/17.
 */
public interface Receipt {
    void printReceipt(Order order);
}
