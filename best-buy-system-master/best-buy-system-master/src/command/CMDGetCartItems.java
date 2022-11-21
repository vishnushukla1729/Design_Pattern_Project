package command;

import model.AbstractItem;

import java.util.List;

/**
 * Created by ehaywo1 on 3/30/2017.
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
