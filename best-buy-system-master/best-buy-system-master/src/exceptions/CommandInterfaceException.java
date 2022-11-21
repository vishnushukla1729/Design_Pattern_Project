package exceptions;

/**
 * Created by ealexhaywood on 5/6/17.
 */
public class CommandInterfaceException extends RuntimeException {
    public CommandInterfaceException() {
        super();
    }

    public CommandInterfaceException(String problem) {
        super(problem);
    }
}
