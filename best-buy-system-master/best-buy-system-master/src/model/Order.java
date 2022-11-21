package model;

import strategy.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ealexhaywood on 5/1/17.
 */
public class Order implements Serializable {
    private OnlineStore onlineStore;
    private User user;
    private List<AbstractItem> orderedItems;
    private UUID orderNumber;
    private String date;
    private ShippingStrategy shippingStrategy;
    private TaxStrategy taxStrategy;
    private double subTotal;
    private double shippingCost;
    private double salesTax;
    private double grandTotal;

    private static final SimpleDateFormat MDY_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
    private static final String DELAWARE = "Delaware";
    private static final String MARYLAND = "Maryland";
    private static final String NEW_YORK = "New York";

    public Order(OnlineStore onlineStore, User user, List<AbstractItem> orderedItems) {
        this.onlineStore = onlineStore;
        this.user = user;
        this.orderedItems = orderedItems;
        this.orderNumber = UUID.randomUUID();
        this.date = MDY_FORMAT.format(new Date());
        this.subTotal = calculateSubTotal(orderedItems);
        this.shippingStrategy = determineShippingStrategy(user);
        this.shippingCost = shippingStrategy.calculateShippingCost(orderedItems);
        this.taxStrategy = determineTaxStrategy(user);
        this.salesTax = taxStrategy.calcSalesTax(subTotal);
        this.grandTotal = subTotal + salesTax + shippingCost;
    }

    private TaxStrategy determineTaxStrategy(User user) {
        switch (user.getLocation()) {
            case DELAWARE:
                return new DETaxStrategy();
            case MARYLAND:
                return new MDTaxStrategy();
            case NEW_YORK:
                return new NYTaxStrategy();
            default:
                return new OtherStateTaxStrategy();
        }
    }

    private ShippingStrategy determineShippingStrategy(User user) {
        if(user.isFirstClass()){
            return new FirstClassShippingStrategy();
        }
        else if (user.isPrime()){
            return new PrimeShippingStrategy();
        }
        else{
            return new RegularShippingStrategy();
        }
    }

    private double calculateSubTotal(List<AbstractItem> orderedItems) {
        double total = 0.0;

        for (AbstractItem item : orderedItems) {
            total += item.getPrice();
        }

        // Round to two decimal places
        return Math.round(total * 100.0) / 100.0;
    }

    public OnlineStore getOnlineStore() {
        return onlineStore;
    }

    public void setOnlineStore(OnlineStore onlineStore) {
        this.onlineStore = onlineStore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AbstractItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<AbstractItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public UUID getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(UUID orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public ShippingStrategy getShippingStrategy() {
        return shippingStrategy;
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public TaxStrategy getTaxStrategy() {
        return taxStrategy;
    }

    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }
}
