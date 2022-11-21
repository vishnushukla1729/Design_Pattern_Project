package model;

/**
 * Created by ealexhaywood on 4/16/17.
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
