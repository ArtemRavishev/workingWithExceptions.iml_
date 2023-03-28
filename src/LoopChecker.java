public class LoopChecker implements Checker {

private static final String ALLOWED_CHARACTERS="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    @Override
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        for (int symbol : chars) {
            if (ALLOWED_CHARACTERS.contains(Character.toString(symbol))) {
                return false;
            }
        }
        return true;
    }
}
