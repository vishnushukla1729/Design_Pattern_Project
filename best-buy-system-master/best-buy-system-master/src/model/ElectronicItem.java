package model;

/**
 * Created by ealexhaywood on 4/16/17.
 */
public class ElectronicItem extends AbstractItem {

    private ElectronicItemType electronicItemType;
    private String displayQuality; // ex: 1080p
    private double screenSize; // 5 inches, 21 inches

    public ElectronicItem(String name, double price, ElectronicItemType electronicItemType, String displayQuality, double screenSize) {
        super(name, price);
        this.electronicItemType = electronicItemType;
        this.displayQuality = displayQuality;
        this.screenSize = screenSize;
    }

    public ElectronicItemType getElectronicItemType() {
        return electronicItemType;
    }

    public void setElectronicItemType(ElectronicItemType electronicItemType) {
        this.electronicItemType = electronicItemType;
    }

    public String getDisplayQuality() {
        return displayQuality;
    }

    public void setDisplayQuality(String displayQuality) {
        this.displayQuality = displayQuality;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "[Name = " + name + ", Price = $" + price + ", Type = " + electronicItemType.toString()
                + ", Display Quality  = " + displayQuality + ", Screen Size = " + screenSize + " inches]";
    }
}
