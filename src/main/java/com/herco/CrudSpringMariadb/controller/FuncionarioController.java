package com.herco.CrudSpringMariadb.controller;

import com.herco.CrudSpringMariadb.controller.dto.FuncionarioRq;
import com.herco.CrudSpringMariadb.controller.dto.FuncionarioRs;
import com.herco.CrudSpringMariadb.model.Funcionario;
import com.herco.CrudSpringMariadb.repository.FuncionarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/")
    public List<FuncionarioRs>findAll(){
        var funcionarios = funcionarioRepository.findAll();
        return funcionarios
                .stream()
                .map(FuncionarioRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FuncionarioRs findById(@PathVariable("id")Long id){
        var funcionario = funcionarioRepository.getOne(id);
        return FuncionarioRs.converter(funcionario);
    }

    @PostMapping("/")
    public void saveFuncionario(@RequestBody FuncionarioRq funcionario){
        var f = new Funcionario();
        f.setNome(funcionario.getNome());
        f.setSobrenome(funcionario.getSobrenome());
        f.setEmail(funcionario.getEmail());
        f.setSalario(funcionario.getSalario());
        funcionarioRepository.save(f);
    }

    @PutMapping("/{id}")
    public void updateFuncionario(@PathVariable("id")Long id,@RequestBody FuncionarioRq funcionario)throws Exception{
        var f = funcionarioRepository.findById(id);

        if(f.isPresent()){
            var funcionarioSave = f.get();
            funcionarioSave.setNome(funcionario.getNome());
            funcionarioSave.setSobrenome(funcionario.getSobrenome());
            funcionarioSave.setEmail(funcionario.getEmail());
            funcionarioSave.setSalario(funcionario.getSalario());
            funcionarioRepository.save(funcionarioSave);
        }else{
            throw new Exception("Funcionario nao encontrado!");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        funcionarioRepository.deleteById(id);
    }
}
