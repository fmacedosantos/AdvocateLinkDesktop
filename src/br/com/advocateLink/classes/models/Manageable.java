package br.com.advocateLink.classes.models;

/**
 * This class has the responsibility of being the tip of the inheritance, it has daughter classes such as: client, employees
 * @version 1.0
 * @author Guilherme Vinicius
 */
public class Manageable {
    protected long id;
    protected String nome;
    protected String cpf;
    protected Address endereco;
    protected Contact contato;
    protected String urlfoto;

    public Manageable(long id, String name, String cpf, Address address, Contact contact, String photograph) {
        this.id = id;
        this.nome = name;
        this.cpf = cpf;
        this.endereco = address;
        this.contato = contact;
        this.urlfoto = photograph;
    }

    public Address getEndereco() {
        return endereco;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Contact getContato() {
        return contato;
    }


    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }
}
