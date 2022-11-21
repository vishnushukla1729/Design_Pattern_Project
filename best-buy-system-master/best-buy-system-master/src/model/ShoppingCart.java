package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ealexhaywood on 4/16/17.
 */
public class ShoppingCart implements Serializable {

    private List<AbstractItem> abstractItems;

    public ShoppingCart() {
        abstractItems = new ArrayList<>();
    }

    public ShoppingCart(List<AbstractItem> abstractItems) {
        this.abstractItems = abstractItems;
    }

    public void add(AbstractItem abstractItem) {
        abstractItems.add(abstractItem);
    }

    public void remove(AbstractItem abstractItem) {
        abstractItems.remove(abstractItem);
    }

    public List<AbstractItem> getAll() {
        return abstractItems;
    }
}
