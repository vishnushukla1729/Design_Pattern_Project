package command;

import model.OnlineStore;
import model.Order;
import model.User;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class CMDCreateOrder implements CommandInterface {

    private Aggregator aggregator;
    private User user;

    public CMDCreateOrder(Aggregator aggregator, User user) {
        this.aggregator = aggregator;
        this.user = user;
    }

    @Override
    public Order execute() {
        Order order = new Order(OnlineStore.getInstance(), user, aggregator.getAll());
        aggregator.setOrder(order);
        return order;
    }
}
