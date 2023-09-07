package classes.models;

public abstract class Administration {
    private static String login = "admin";
    private static String password ="admin";

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }
}
