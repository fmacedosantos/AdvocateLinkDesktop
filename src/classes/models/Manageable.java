package classes.models;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getEndereco() {
        return endereco;
    }

    public void setEndereco(Address endereco) {
        this.endereco = endereco;
    }

    public Contact getContato() {
        return contato;
    }

    public void setContato(Contact contato) {
        this.contato = contato;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }
}
