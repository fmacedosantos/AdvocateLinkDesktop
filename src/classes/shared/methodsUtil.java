package classes.shared;

import javax.swing.*;

public abstract class methodsUtil {

    // VALIDA SE UM CAMPO SERA STRING OU NUMERO, SE CASO FOR STRING RETORNARAR ERROR
    public static int validaNumero(Object numero) throws NumberFormatException{
        if ((numero instanceof String)) {
            throw new NumberFormatException();
        }
        return (int) numero;
    }
    // VALIDA SE TODOS OS CAMPOS FORAM COMPLETADOS
    public static boolean validaCampos(JTextField tf1,JTextField tf2,JTextField tf3,JTextField tf4,JTextField tf5,JTextField tf6){
        if (!tf1.getText().isEmpty()&&!tf2.getText().isEmpty()&&!tf3.getText().isEmpty()&&!tf4.getText().isEmpty()&&!tf5.getText().isEmpty()&&!tf6.getText().isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    // VALIDA SE TODOS OS CAMPOS FORAM COMPLETADOS
    public static boolean validaCampos(JTextField tf1,JTextField tf2){
        if (!tf1.getText().isEmpty()&&!tf2.getText().isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
