package com.example.projectfuncionario.servico;

import java.util.List;

import com.example.projectfuncionario.entidade.Funcionario;
import com.example.projectfuncionario.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FuncionarioServico
 */
@Service
public class FuncionarioServico {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> getFuncionarios(){
        return repository.findAll();
    }

    public void insertFuncionario(Funcionario funcionario){
        repository.save(funcionario);
    }
}