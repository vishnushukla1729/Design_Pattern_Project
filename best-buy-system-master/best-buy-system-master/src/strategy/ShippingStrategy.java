package strategy;
import model.AbstractItem;

import java.util.List;

/**
 * Created by tylerhoward on 5/12/17.
 */
public interface ShippingStrategy {
    double calculateShippingCost(List<AbstractItem> orderedItems);
}
