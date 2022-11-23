package model;
/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public enum ElectronicItemType {
    CELL_PHONE("Cell Phone"), LAPTOP("Laptop"), DESKTOP_PC("Desktop PC");

    private final String type;

    ElectronicItemType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
