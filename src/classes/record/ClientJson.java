package classes.record;

import classes.models.Address;
import classes.models.Contact;

public record ClientJson(String id, String nome, String cpf, Address endereco, Contact contato, String urlfoto, String oab, String areaAtuacao) {
}
