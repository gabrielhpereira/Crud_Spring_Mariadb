package com.herco.CrudSpringMariadb.controller.dto;

import com.herco.CrudSpringMariadb.model.Funcionario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioRs {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private Float salario;

    public static FuncionarioRs converter(Funcionario f){
        var funcionario = new FuncionarioRs();
        funcionario.setId(f.getId());
        funcionario.setNome(f.getNome());
        funcionario.setSobrenome(f.getSobrenome());
        funcionario.setEmail(f.getEmail());
        funcionario.setSalario(f.getSalario());
        return funcionario;
    }
}
