package strategy;

import model.AbstractItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tylerhoward on 5/12/17.
 */
public class PrimeShippingStrategy implements ShippingStrategy, Serializable {
    @Override
    public double calculateShippingCost(List<AbstractItem> orderedItems) {
        return 0.0;
    }
}
