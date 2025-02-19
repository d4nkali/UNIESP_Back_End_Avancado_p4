package com.example.demo.controller;

import com.example.demo.pessoa.CadastroPessoaDados;
import com.example.demo.pessoa.Pessoa;
import com.example.demo.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody CadastroPessoaDados dados) {

        repository.save(new Pessoa(dados));

    }

}
