package com.herco.CrudSpringMariadb.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioRq {

    private String nome;
    private String sobrenome;
    private String email;
    private Float salario;
}
