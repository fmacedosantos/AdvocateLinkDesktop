package classes.models;

public class Contact {
    private long telefone;
    private String email;

    public Contact(long telephone, String email) {
        this.telefone = telephone;
        this.email = email;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


