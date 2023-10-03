package br.com.advocateLink.classes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * class to initialize an Address
 *  @version 1.0
 *  @author Guilherme Vinicius
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String rua;
    private int numero;
    private String bairro;
}
