package br.com.advocateLink.classes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @version 1.0
 * @author Guilherme Vinicius
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clients extends Manageable {
    private String oab;
    private String areaAtuacao;

    public Clients(long id, String name, String cpf, Address address, Contact contact, String photograph, String oab, String actingArea) {
        super(id, name, cpf, address, contact, photograph);
        this.oab = oab;
        this.areaAtuacao = actingArea;
    }
}
