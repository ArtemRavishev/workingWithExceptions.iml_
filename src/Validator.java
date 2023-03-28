import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Validator {

    private Validator() {
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            cheсk(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    private static void cheсk(String login, String password, String confirmPassword)
            throws WrongPasswordException, WrongLoginException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше или равна 20");
        }
        if (Objects.isNull(password) || password.length() >= 20) {
            throw new WrongLoginException("Длина пароля должна быть меньше 20");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongLoginException("Пароли должны совпадать");
        }
        Checker checker = ThreadLocalRandom.current().nextBoolean() ?
                new LoopChecker() :
                new RegexChecker();

        if (!checker.isValid(login)) {
            throw new WrongPasswordException("Логин содержит некорретные символы");
        }
        if (!checker.isValid(password)) {
            throw new WrongPasswordException("Пароль содержит некорретные символы");
        }


    }
}


