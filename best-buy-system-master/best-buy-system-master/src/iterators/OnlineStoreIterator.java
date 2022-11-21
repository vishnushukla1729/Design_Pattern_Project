package iterators;

import model.AbstractItem;

/**
 * Actual iterators are contained in the OnlineStore class
 *
 * Created by ealexhaywood on 4/16/17.
 */
public interface OnlineStoreIterator {
    boolean hasNext();
    AbstractItem next();
}
