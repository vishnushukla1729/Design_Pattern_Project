package strategy;
import model.AbstractItem;

import java.util.List;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public interface ShippingStrategy {
    double calculateShippingCost(List<AbstractItem> orderedItems);
}
