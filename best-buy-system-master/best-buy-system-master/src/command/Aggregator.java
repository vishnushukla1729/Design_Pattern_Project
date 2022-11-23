package command;

import decorator.Receipt;
import decorator.SimpleReceipt;
import model.AbstractItem;
import model.Order;
import model.ShoppingCart;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class Aggregator implements Serializable {
    private ShoppingCart shoppingCart;
    private Receipt receipt;
    private Order order;

    public Aggregator() {
        shoppingCart = new ShoppingCart();
        receipt = new SimpleReceipt();
    }

    public void add(AbstractItem abstractItem) {
        shoppingCart.add(abstractItem);
    }

    public void remove(AbstractItem abstractItem) {
        shoppingCart.remove(abstractItem);
    }

    public List<AbstractItem> getAll() {
        return shoppingCart.getAll();
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
