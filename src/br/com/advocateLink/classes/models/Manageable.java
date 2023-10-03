package br.com.advocateLink.classes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class has the responsibility of being the tip of the inheritance, it has daughter classes such as: client, employees
 * @version 1.0
 * @author Guilherme Vinicius
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manageable {
    protected long id;
    protected String nome;
    protected String cpf;
    protected Address endereco;
    protected Contact contato;
    protected String urlfoto;
}
