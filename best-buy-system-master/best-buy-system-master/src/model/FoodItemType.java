package model;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public enum FoodItemType {
    MEAT("Meat"), FRUIT("Fruit"), VEGETABLES("Vegetables"), SNACKS("Snacks");

    private final String type;

    FoodItemType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
