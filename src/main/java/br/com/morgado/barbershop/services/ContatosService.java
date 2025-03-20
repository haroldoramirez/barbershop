package br.com.morgado.barbershop.services;

import br.com.morgado.barbershop.models.entity.Contato;

import java.util.List;

public interface ContatosService {

    Contato salvar(Contato contato);

    void validar(Contato contato);

    List<Contato> listarPorDataDecrescente();

}
