public class WrongLoginException extends Exception {

    private final static String MESSAGE = "Wrong login exception";

    public WrongLoginException() {super(MESSAGE);}

    public WrongLoginException(String message) {
        super(message);
    }
}
