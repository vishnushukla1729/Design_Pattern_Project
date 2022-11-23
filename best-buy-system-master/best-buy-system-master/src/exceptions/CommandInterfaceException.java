package exceptions;

/**
 * Created by Vishnu Shukla on 21/11/22.
 */
public class CommandInterfaceException extends RuntimeException {
    public CommandInterfaceException() {
        super();
    }

    public CommandInterfaceException(String problem) {
        super(problem);
    }
}
