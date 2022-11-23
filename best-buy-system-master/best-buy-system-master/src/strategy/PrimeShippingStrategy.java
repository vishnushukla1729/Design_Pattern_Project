package strategy;

import model.AbstractItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class PrimeShippingStrategy implements ShippingStrategy, Serializable {
    @Override
    public double calculateShippingCost(List<AbstractItem> orderedItems) {
        return 0.0;
    }
}
