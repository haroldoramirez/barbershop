package br.com.morgado.barbershop.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @GetMapping("/criar")
    public String paginaCriar() {
        return "clientes/criar";
    }

    @GetMapping("/detalhe")
    public String paginaDetalhe() {
        return "clientes/detalhe";
    }

    @GetMapping("/editar")
    public String paginaEditar() {
        return "clientes/editar";
    }

    @GetMapping("/listar")
    public String paginaListar() {
        return "clientes/listar";
    }

}