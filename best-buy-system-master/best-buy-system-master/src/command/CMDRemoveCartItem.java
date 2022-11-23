package command;

import model.AbstractItem;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class CMDRemoveCartItem implements CommandInterface {

    private AbstractItem abstractItem;
    private Aggregator aggregator;

    public CMDRemoveCartItem(AbstractItem abstractItem, Aggregator aggregator) {
        this.abstractItem = abstractItem;
        this.aggregator = aggregator;
    }

    @Override
    public AbstractItem execute() {
        aggregator.remove(abstractItem);
        return abstractItem;
    }
}
