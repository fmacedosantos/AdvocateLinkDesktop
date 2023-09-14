package br.com.advocateLink.classes.exceptions;

/**
 * This class is an exception used when in some form there is a lack of information to continue the POST method.
 * @version 1.0
 * @author Guilherme Vinicius
 */
public class LackOfInformationException extends RuntimeException{
    /**
     *
     * @param message
     */
    public LackOfInformationException(String message) {
        super(message);
    }
}
