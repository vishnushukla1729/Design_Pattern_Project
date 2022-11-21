package model;

import iterators.OnlineStoreIterator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ehaywo1 on 3/30/2017.
 */
public class OnlineStore implements Serializable {

    private static OnlineStore onlineStore = new OnlineStore();

    private OnlineStore() {
    }

    public static OnlineStore getInstance() {
        return onlineStore;
    }

    private List<AbstractItem> inventory;

    public OnlineStoreIterator getAllItemsIterator() {
        return new AllItemsIterator();
    }

    public OnlineStoreIterator getAllItemsIterator(List<AbstractItem> items) {
        return new AllItemsIterator(items);
    }

    public OnlineStoreIterator getElectronicItemsIterator() {
        return new ElectronicItemsIterator();
    }

    public OnlineStoreIterator getElectronicItemsIterator(List<AbstractItem> items) {
        return new ElectronicItemsIterator(items);
    }

    public OnlineStoreIterator getClothingItemsIterator() {
        return new ClothingItemsIterator();
    }

    public OnlineStoreIterator getClothingItemsIterator(List<AbstractItem> items) {
        return new ClothingItemsIterator(items);
    }

    public OnlineStoreIterator getFoodItemsIterator() {
        return new FoodItemsIterator();
    }

    public OnlineStoreIterator getFoodItemsIterator(List<AbstractItem> items) {
        return new FoodItemsIterator(items);
    }

    public OnlineStoreIterator getGenericItemsIterator() {
        return new GenericItemsIterator();
    }

    public OnlineStoreIterator getGenericItemsIterator(List<AbstractItem> items) {
        return new GenericItemsIterator(items);
    }


    private class AllItemsIterator implements OnlineStoreIterator {

        private List<AbstractItem> items;
        private int index = 0;

        public AllItemsIterator() {
            this.items = inventory;
        }

        public AllItemsIterator(List<AbstractItem> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            if (index < items.size()) {
                return true;
            }
            return false;
        }

        @Override
        public AbstractItem next() {
            return items.get(index++);
        }
    }

    private class ElectronicItemsIterator implements OnlineStoreIterator {

        private List<AbstractItem> items;
        private int index = 0;

        public ElectronicItemsIterator() {
            this.items = inventory;
        }

        public ElectronicItemsIterator(List<AbstractItem> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            for (int i = index; i < items.size(); i++) {
                if (items.get(i) instanceof ElectronicItem) {
                    index = i;
                    return true;
                }
            }
            return false;
        }

        @Override
        public AbstractItem next() {
            return items.get(index++);
        }
    }

    private class ClothingItemsIterator implements OnlineStoreIterator {

        private List<AbstractItem> items;
        private int index = 0;

        public ClothingItemsIterator() {
            this.items = inventory;
        }

        public ClothingItemsIterator(List<AbstractItem> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            for (int i = index; i < items.size(); i++) {
                if (items.get(i) instanceof ClothingItem) {
                    index = i;
                    return true;
                }
            }
            return false;
        }

        @Override
        public AbstractItem next() {
            return items.get(index++);
        }
    }

    private class FoodItemsIterator implements OnlineStoreIterator {

        private List<AbstractItem> items;
        private int index = 0;

        public FoodItemsIterator() {
            this.items = inventory;
        }

        public FoodItemsIterator(List<AbstractItem> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            for (int i = index; i < items.size(); i++) {
                if (items.get(i) instanceof FoodItem) {
                    index = i;
                    return true;
                }
            }
            return false;
        }

        @Override
        public AbstractItem next() {
            return items.get(index++);
        }
    }


    private class GenericItemsIterator implements OnlineStoreIterator {

        private List<AbstractItem> items;
        private int index = 0;

        public GenericItemsIterator() {
            this.items = inventory;
        }

        public GenericItemsIterator(List<AbstractItem> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            for (int i = index; i < items.size(); i++) {
                if (items.get(i) instanceof GenericItem) {
                    index = i;
                    return true;
                }
            }
            return false;
        }

        @Override
        public AbstractItem next() {
            return items.get(index++);
        }
    }

    public List<AbstractItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<AbstractItem> inventory) {
        this.inventory = inventory;
    }
}
