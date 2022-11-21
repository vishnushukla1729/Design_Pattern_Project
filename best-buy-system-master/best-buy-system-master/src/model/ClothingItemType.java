package model;

/**
 * Created by ealexhaywood on 4/16/17.
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
