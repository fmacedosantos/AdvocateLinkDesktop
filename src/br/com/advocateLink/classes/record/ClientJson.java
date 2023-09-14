package br.com.advocateLink.classes.record;

import br.com.advocateLink.classes.models.Contact;
import br.com.advocateLink.classes.models.Address;

/** this record has the function of initializing an object of type Client, passingthis
 *  record has the function of initializing an object of type Client, passing through the parameters a Json
 * @version 1.0
 * @author Guilherme Vinicius
 * @param id
 * @param nome
 * @param cpf
 * @param endereco
 * @param contato
 * @param urlfoto
 * @param oab
 * @param areaAtuacao
 */
public record ClientJson(String id, String nome, String cpf, Address endereco, Contact contato, String urlfoto, String oab, String areaAtuacao) {
}
