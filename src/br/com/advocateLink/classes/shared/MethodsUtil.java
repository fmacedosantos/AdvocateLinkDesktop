package br.com.advocateLink.classes.shared;

import javax.swing.*;

/**This class will do, processing within a class, for example, validate input, and verify that a number sent really is number.
 * @author Guilherme vinicius
 * @version 1.0
 */
public abstract class MethodsUtil {
    /**
     * VALIDATES WHETHER A FIELD WILL BE STRING OR NUMBER, IF STRING RETURNS ERROR.
     * @param numero
     * @return
     * @throws NumberFormatException
     */
    public static Object validatesNumber(Object numero) throws NumberFormatException {
        if ((numero instanceof String)) {
            throw new NumberFormatException();
        }
        return numero;
    }
    public static boolean validatesInput(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6, JTextField tf7) {
        return (!tf1.getText().isEmpty() && !tf2.getText().isEmpty() && !tf3.getText().isEmpty() && !tf4.getText().isEmpty() &&
                !tf5.getText().isEmpty() && !tf6.getText().isEmpty()&&!tf7.getText().isEmpty());
    }

    // VALIDA SE TODOS OS CAMPOS FORAM COMPLETADOS
    public static boolean validatesInput(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6) {
        return (!tf1.getText().isEmpty() && !tf2.getText().isEmpty() && !tf3.getText().isEmpty() && !tf4.getText().isEmpty() &&
                !tf5.getText().isEmpty() && !tf6.getText().isEmpty());
         }

    // VALIDA SE TODOS OS CAMPOS FORAM COMPLETADOS
    public static boolean validatesInput(JTextField tf1, JTextField tf2) {
        return (!tf1.getText().isEmpty() && !tf2.getText().isEmpty());
    }

    /**
     * SEARCH THE CUSTOMER FROM THE NAME.
     * @param name
     * @return
     * @throws NullPointerException
     */
}
