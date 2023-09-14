package br.com.advocateLink.classes.exceptions;

/**This class is an exception used when in some information it has to receive some numeric type, but actually passes a String.
 * @version 1.0
 * @author Guilherme vinicius
 */
public class NegativeNumberException extends RuntimeException{
    /**
     *
     * @param message
     */
    public NegativeNumberException(String message) {
        super(message);
    }
}
