package strategy;

import java.io.Serializable;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class DETaxStrategy implements TaxStrategy, Serializable {
    @Override
    public double calcSalesTax(double price) {
        return 0.0; //No sales tax
    }
}
