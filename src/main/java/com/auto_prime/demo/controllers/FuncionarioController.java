package com.auto_prime.demo.controllers;

import com.auto_prime.demo.services.FuncionarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {


    private FuncionarioService service;



}
