package com.herco.CrudSpringMariadb.controller.dto;

import com.herco.CrudSpringMariadb.model.Funcionario;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }
}
