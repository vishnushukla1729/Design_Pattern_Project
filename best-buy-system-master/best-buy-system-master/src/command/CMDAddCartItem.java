package command;

import model.AbstractItem;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class CMDAddCartItem implements CommandInterface {

    private AbstractItem abstractItem;
    private Aggregator aggregator;

    public CMDAddCartItem(AbstractItem abstractItem, Aggregator aggregator) {
        this.abstractItem = abstractItem;
        this.aggregator = aggregator;
    }

    @Override
    public AbstractItem execute() {
        aggregator.add(abstractItem);
        return abstractItem;
    }
}
