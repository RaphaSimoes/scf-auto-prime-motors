package com.auto_prime.demo.controllers;

import com.auto_prime.demo.dto.FuncionarioDTO;
import com.auto_prime.demo.entities.Funcionario;
import com.auto_prime.demo.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Documented;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {


    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioDTO> criar (@RequestBody FuncionarioDTO dto){
        FuncionarioDTO criado = service.criarFuncionario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listartodos(){
        List<FuncionarioDTO> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarPorId(@PathVariable String id){
        FuncionarioDTO dto = service.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
        public ResponseEntity<FuncionarioDTO> atualizar (@PathVariable String id,
                                                         @RequestBody FuncionarioDTO dto){
        FuncionarioDTO atualizado = service.atualizarFuncionario(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarFuncionario(@PathVariable String id){
        service.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }


}
