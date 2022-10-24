public class WrongPasswordException extends Exception {

    private final static String MESSAGE = "Wrong password exception";

    public WrongPasswordException() {super(MESSAGE);}

    public WrongPasswordException(String message) {super(message);}
}
