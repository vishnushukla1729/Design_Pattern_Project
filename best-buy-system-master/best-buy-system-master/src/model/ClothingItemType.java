package model;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public enum ClothingItemType {
    SHIRT("Shirt"), PANTS("Pants"), SHOES("Shoes");

    private final String type;

    ClothingItemType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
