package command;

import decorator.*;

/**
 * Created by ealexhaywood on 5/7/17.
 */
public class CMDPrintReceipt implements CommandInterface {

    private Aggregator aggregator;
    private String type;

    public CMDPrintReceipt(Aggregator aggregator, String type) {
        this.aggregator = aggregator;
        this.type = type;
    }

    @Override
    public Receipt execute() {

        Receipt currentReceipt = aggregator.getReceipt();

        switch (type) {
            case "all":
                aggregator.setReceipt(new AllItemDecorator(currentReceipt));
                break;
            case "clothing":
                aggregator.setReceipt(new ClothingItemDecorator(currentReceipt));
                break;
            case "electronic":
                aggregator.setReceipt(new ElectronicItemDecorator(currentReceipt));
                break;
            case "food":
                aggregator.setReceipt(new FoodItemDecorator(currentReceipt));
                break;
            case "generic":
                aggregator.setReceipt(new GenericItemDecorator(currentReceipt));
                break;
            default:
                // do nothing
                break;
        }

        Receipt newReceipt = aggregator.getReceipt();
        newReceipt.printReceipt(aggregator.getOrder());
        return newReceipt;
    }
}
