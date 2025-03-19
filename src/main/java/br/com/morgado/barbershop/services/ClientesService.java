package br.com.morgado.barbershop.services;

import br.com.morgado.barbershop.models.entity.Cliente;

import java.util.List;

public interface ClientesService {

    Cliente salvarCliente(Cliente cliente);

    void validarCliente(Cliente cliente);

    List<Cliente> listarClientesPorDataDecrescente();

}
