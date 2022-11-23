package command;

import model.AbstractItem;

import java.util.List;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class CMDGetCartItems implements CommandInterface {

    private Aggregator aggregator;

    public CMDGetCartItems(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Override
    public List<AbstractItem> execute() {
        return aggregator.getAll();
    }
}
