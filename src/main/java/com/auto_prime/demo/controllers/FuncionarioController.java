package com.auto_prime.demo.controllers;

import com.auto_prime.demo.dto.FuncionarioDTO;
import com.auto_prime.demo.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public String listarFuncionarios(Model model) {
        List<FuncionarioDTO> listaDeFuncionarios = service.buscarFuncionario(); // Usando DTO para consistência
        model.addAttribute("listaFuncionarios", listaDeFuncionarios);
        model.addAttribute("funcionarioForm", new FuncionarioDTO()); // Objeto para o form de cadastro
        return "funcionarios";
    }

    @PostMapping("/salvar")
    public String salvarFuncionario(@ModelAttribute("funcionarioForm") FuncionarioDTO funcionarioDTO) {
        if (funcionarioDTO.getId() != null) {
            service.atualizarFuncionario(funcionarioDTO.getId(), funcionarioDTO);
        } else {
            service.criarFuncionario(funcionarioDTO);
        }
        return "redirect:/funcionarios";
    }

    @PostMapping("/excluir/{id}")
    public String excluirFuncionario(@PathVariable Long id) {
        service.deletarFuncionario(id);
        return "redirect:/funcionarios";
    }
}