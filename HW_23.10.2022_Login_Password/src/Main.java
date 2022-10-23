import java.io.IOException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
//First level: 1. Создать статический метод который принимает на вход три параметра:
// login, password и confirmPassword.
//
//Login должен содержать только латинские буквы, цифры и знак подчеркивания.
//
//Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям,
// необходимо выбросить WrongLoginException.
//
//Password должен содержать только латинские буквы, цифры и знак подчеркивания.
// Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
// Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//
//WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами –
// один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
//
//Обработка исключений проводится внутри метода.
//
//Используем multi-catch block.
//
//Метод возвращает true, если значения верны или false в другом случае.

        System.out.println("Condition№1: All is correct:" + '\n' + "***********************************************");
        System.out.println(validation("Anton123_456", "Kliuchnikov_109238", "Kliuchnikov_109238"));
        System.out.println("Condition№2: Wrong length:" + '\n' + "***********************************************");
        System.out.println(validation("Anton123_456ghfh4h56hhff46j", "Kliuchnikov_109238_11111111111", "Kliuchnikov_109238_11111111111"));
        System.out.println("Condition№1: Wrong symbols and wrong conformation:" + '\n' + "***********************************************");
        System.out.println(validation("Антон-Ключников", "Антон-Ключников", "Антон-Богданов"));


    }

    private static boolean validation(String login, String password, String confirmPassword) {
        int maxLength = 20;
        int count = 0;
        try {
            if (login.length() < maxLength && Objects.equals(login, login.replaceAll("[^\\da-zA-Z_]", ""))) {
                System.out.println("Login is correct");
                count++;
            } else {
                throw new WrongLoginException("Incorrect login");
            }
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (password.length() < maxLength && Objects.equals(password, password.replaceAll("[^\\da-zA-Z_]", ""))) {
                System.out.println("Password is correct");
                count++;
                ;
            } else {
                throw new WrongPasswordException("Incorrect Password");
            }
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (Objects.equals(password, confirmPassword)) {
                System.out.println("Password is confirmed");
                count++;
            } else {
                throw new WrongPasswordException("Incorrect confirmPassword");
            }
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count == 3;
    }
}

class WrongLoginException extends Exception {
    public WrongLoginException() {
    }

    public WrongLoginException(String incorrect_login) {
        super(incorrect_login);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
    }

    public WrongPasswordException(String incorrect_password) {
        super(incorrect_password);
    }
}
