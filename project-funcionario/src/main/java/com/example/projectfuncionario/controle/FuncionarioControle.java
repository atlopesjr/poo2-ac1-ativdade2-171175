package com.example.projectfuncionario.controle;

import com.example.projectfuncionario.entidade.Funcionario;
import com.example.projectfuncionario.servico.FuncionarioServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * FuncionarioControle
 */
@Controller
public class FuncionarioControle {

    @Autowired
    private FuncionarioServico servico;

    @PostMapping("/cadastrar")
    public String insertFuncionario(@ModelAttribute Funcionario funcionario){
        if(funcionario.getNome().trim().isEmpty() || funcionario.getDepartamento().trim().isEmpty() || funcionario.getCargo().trim().isEmpty() || funcionario.getSalario() < 0){
            return "redirect:/error";
        } else {
            servico.insertFuncionario(funcionario);
            return "redirect:/funcionarios";
        }
    }

    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarios(){
        ModelAndView mv = new ModelAndView("funcionarios");
        mv.addObject("funcionarios", servico.getFuncionarios());
        return mv;
    }
}