package model;

/**
 * Created by ealexhaywood on 4/16/17.
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
