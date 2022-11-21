package strategy;

import java.io.Serializable;

/**
 * Created by tylerhoward on 5/12/17.
 */
public class NYTaxStrategy implements TaxStrategy, Serializable {
    @Override
    public double calcSalesTax(double price) {
        double tax = price * 0.08875; //average sales tax in NYS
        return Math.round(tax * 100.0) / 100.0; // round to 2 decimal places
    }
}
