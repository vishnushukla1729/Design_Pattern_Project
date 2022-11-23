package strategy;

import model.AbstractItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class FirstClassShippingStrategy implements ShippingStrategy, Serializable {
    @Override
    public double calculateShippingCost(List<AbstractItem> orderedItems){
        double flatCost = 9.99;
        double addedCost = orderedItems.size() * 2.99;
        return Math.round((flatCost + addedCost) * 100.0) / 100.0;
    }
}
