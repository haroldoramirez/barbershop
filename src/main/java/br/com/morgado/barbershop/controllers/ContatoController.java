package br.com.morgado.barbershop.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/contatos")
public class ContatoController {

    Logger logger = LoggerFactory.getLogger(ContatoController.class);

    @GetMapping("/detalhe")
    public String paginaDetalhe() {
        return "clientes/detalhe";
    }

    @GetMapping("/listar")
    public String paginaListar() {
        return "clientes/listar";
    }

    /**
     * metodo responsavel por criar
     */
    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestParam(value = "contato", required = true) JSONPObject contato) {
        return ResponseEntity.ok("Ok - Cadastrado com sucesso!");
    }

}
