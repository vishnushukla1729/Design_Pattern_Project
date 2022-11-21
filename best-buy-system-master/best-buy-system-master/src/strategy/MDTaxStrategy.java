package strategy;

import java.io.Serializable;

/**
 * Created by tylerhoward on 5/12/17.
 */
public class MDTaxStrategy implements TaxStrategy, Serializable {
    @Override
    public double calcSalesTax(double price) {
        double tax = price * 0.06; //sales tax in MD
        return Math.round(tax * 100.0) / 100.0; // round to 2 decimal places
    }
}
