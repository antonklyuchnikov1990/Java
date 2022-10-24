public class Main {

    public static void main(String[] args) {
        System.out.println(check("qwerty_12", "password", "password"));
        System.out.println(check("qwertyпроверка_12", "password", "password"));
        System.out.println(check("qwerty_12", "password", "password2"));
        System.out.println(check("qwertyregerhrehreh_1245654654646464646644654", "password", "password"));
    }

    private static boolean check(
            String login,
            String password,
            String confirmPassword
    ) {
        try {
            if (!stringCheck2(login)) {
                throw new WrongLoginException();
            }
            if (!stringCheck2(password)) {
                throw new WrongPasswordException();
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("ConfirmPassword is not equals Password");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }

    private static boolean stringCheck(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890_";
        for (int i = 0; i < s.length(); i++) {
            if (!alphabet.contains(s.substring(i, i + 1).toLowerCase())) {
                return true;
            }
        }
        return s.length() >= 20;
    }

    // TODO remake if!
    private static boolean stringCheck2(String s) {
        if (s.length() >= 20) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '_'){
                return true;
            }
        }
        return true;
    }
}
