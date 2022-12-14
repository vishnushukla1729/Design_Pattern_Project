package model;

import java.io.Serializable;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public abstract class AbstractItem implements Serializable {

    protected String name;
    protected double price;

    public AbstractItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[name = " + name + ", price = " + price + "]";
    }
}
