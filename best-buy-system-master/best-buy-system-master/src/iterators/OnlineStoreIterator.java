package iterators;

import model.AbstractItem;

/**
 * Actual iterators are contained in the OnlineStore class
 *
/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public interface OnlineStoreIterator {
    boolean hasNext();
    AbstractItem next();
}
