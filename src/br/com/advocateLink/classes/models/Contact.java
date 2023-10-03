package br.com.advocateLink.classes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * class to initialize a Contact
 *  @version 1.0
 *  @author Guilherme Vinicius
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private long telefone;
    private String email;
}


