package decorator;

import model.Order;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public interface Receipt {
    void printReceipt(Order order);
}
