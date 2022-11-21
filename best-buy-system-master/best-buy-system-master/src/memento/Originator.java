package memento;

import command.Aggregator;

import java.io.*;

/**
 * Created by ealexhaywood on 5/14/17.
 */
public class Originator {

    private Aggregator aggregator;

    public Originator() {}

    public void set(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    public Memento saveToMemento() {
        return new Memento(this.aggregator);
    }

    public Aggregator restoreFromMemento(Memento memento) {
        this.aggregator = memento.getSavedState();
        return aggregator;
    }

    public static class Memento {
        private byte[] byteData;

        // Need a deep copy of aggregator in order to truly save states, so let's store it as a byte array
        public Memento(Aggregator aggregator) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(bos);
                oos.writeObject(aggregator);
                oos.flush();
                oos.close();
                bos.close();
                byte[] byteData = bos.toByteArray();
                this.byteData = byteData;
            } catch (IOException e) {
                System.out.println("Unable to save system state.  Reason: Not serializable.");
                throw new RuntimeException(e);
            }
        }

        // Deserialize from byte array back to aggregator
        public Aggregator getSavedState() {
            ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
            Object aggregator = null;
            try {
                aggregator = new ObjectInputStream(bais).readObject();
            } catch (IOException e) {
                System.out.println("Unable to restore system state.  Reason: Not deserializable.");
            } catch (ClassNotFoundException e) {
                System.out.println("Unable to restore system state.  Reason: Class not found.");
            }
            return (Aggregator) aggregator;
        }
    }
}
