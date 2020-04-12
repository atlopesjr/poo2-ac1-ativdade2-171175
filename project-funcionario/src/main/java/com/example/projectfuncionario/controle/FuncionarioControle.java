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
    public ModelAndView insertFuncionario(@ModelAttribute Funcionario funcionario){
        ModelAndView mv = new ModelAndView();
        if(funcionario == null){
            mv.setViewName("error");
        } else {
            servico.insertFuncionario(funcionario);
            mv.setViewName("redirect:/funcionarios");
        }
        mv.addObject("funcionarios", funcionario);
        return mv;
    }

    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarios(){
        ModelAndView mv = new ModelAndView("funcionarios");
        mv.addObject("funcionarios", servico.getFuncionarios());
        return mv;
    }
}