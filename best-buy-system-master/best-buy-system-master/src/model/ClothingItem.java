package model;

/**
 * Created by ealexhaywood on 4/16/17.
 */
public class ClothingItem extends AbstractItem {

    private ClothingItemType clothingItemType;
    private String size;
    private boolean youth;

    public ClothingItem(String name, double price, ClothingItemType clothingItemType, String size, boolean youth) {
        super(name, price);
        this.clothingItemType = clothingItemType;
        this.size = size;
        this.youth = youth;
    }

    public ClothingItemType getClothingItemType() {
        return clothingItemType;
    }

    public void setClothingItemType(ClothingItemType clothingItemType) {
        this.clothingItemType = clothingItemType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isYouth() {
        return youth;
    }

    public void setYouth(boolean youth) {
        this.youth = youth;
    }

    @Override
    public String toString() {
        return "[Name = " + name + ", Price = $" + price + ", Type = " + clothingItemType.toString()
                + ", Size = " + size + ", Youth = " + youth + "]";
    }
}
