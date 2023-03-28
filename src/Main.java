public class Main {

    public static void main(String[] args){
        boolean result = Validator.validate("AceSteel111_", "12124AS4124_9", "12124AS4124_9");
        if (result) {
            System.out.println(" Логин и пароль корректные");
        }else {
            System.out.println(" Логин и/или пароль некорретный");
        }
    }
}