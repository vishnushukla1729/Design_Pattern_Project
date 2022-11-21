package model;

/**
 * Created by ealexhaywood on 4/16/17.
 */
public class FoodItem extends AbstractItem {

    private FoodItemType foodItemType;
    private boolean vegetarian;

    public FoodItem(String name, double price, FoodItemType foodItemType, boolean vegetarian) {
        super(name, price);
        this.foodItemType = foodItemType;
        this.vegetarian = vegetarian;
    }

    public FoodItemType getFoodItemType() {
        return foodItemType;
    }

    public void setFoodItemType(FoodItemType foodItemType) {
        this.foodItemType = foodItemType;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return "[Name = " + name + ", Price = $" + price + ", Type = " + foodItemType.toString()
                + ", Vegetarian = " + vegetarian + "]";
    }
}
