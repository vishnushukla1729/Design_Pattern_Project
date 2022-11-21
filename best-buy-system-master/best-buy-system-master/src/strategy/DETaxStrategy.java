package strategy;

import java.io.Serializable;

/**
 * Created by tylerhoward on 5/12/17.
 */
public class DETaxStrategy implements TaxStrategy, Serializable {
    @Override
    public double calcSalesTax(double price) {
        return 0.0; //No sales tax
    }
}
