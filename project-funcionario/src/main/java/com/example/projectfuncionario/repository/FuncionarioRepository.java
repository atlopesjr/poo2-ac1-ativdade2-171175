package com.example.projectfuncionario.repository;

import com.example.projectfuncionario.entidade.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Integer> {
    
}