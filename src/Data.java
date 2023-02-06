public class Data {

    private static final String VALID_CHARLIST= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890_";

    private Data() {

    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try{
            check(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!validate(login)) {
            throw new WrongLoginException("логин неправильный");
        }
        if (!validate(password)) {
            throw new WrongPasswordException("пароль нерпавильный");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("пароли должны совпадать");
        }
    }

    private static boolean validate(String a){
        if (a.length() > 20){
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if(!VALID_CHARLIST.contains(String.valueOf(a.charAt(i)))){
                return false;
            }
        }
        return true;
    }

}