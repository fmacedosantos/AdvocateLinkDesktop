package br.com.advocateLink.classes.models;

/**
 * @version 1.0
 * @author Guilherme Vinicius
 */
public class Clients extends Manageable {
    private String oab;
    private String areaAtuacao;

    public Clients(long id, String name, String cpf, Address address, Contact contact, String photograph, String oab, String actingArea) {
        super(id, name, cpf, address, contact, photograph);
        this.oab = oab;
        this.areaAtuacao = actingArea;
    }
    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
}
