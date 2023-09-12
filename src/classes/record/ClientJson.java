package classes.record;

import classes.models.Contact;
import classes.models.Address;

public record ClientJson(String id, String nome, String cpf, Address endereco, Contact contato, String urlfoto, String oab, String areaAtuacao) {
}
