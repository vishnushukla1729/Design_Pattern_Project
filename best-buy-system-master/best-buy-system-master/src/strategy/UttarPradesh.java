package strategy;

import java.io.Serializable;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class NYTaxStrategy implements TaxStrategy, Serializable {
    @Override
    public double calcSalesTax(double price) {
        double tax = price * 0.08875; //average sales tax in NYS
        return Math.round(tax * 100.0) / 100.0; // round to 2 decimal places
    }
}
