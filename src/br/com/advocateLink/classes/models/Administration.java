package br.com.advocateLink.classes.models;

/**Administrator class, here is information to follow up the app
 * @version 1.0
 *  @author Guilherme Vinicius
 */
public abstract class Administration {
    private final static String login = "admin";
    private final static String password ="admin";

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }
}
