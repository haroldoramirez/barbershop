package br.com.morgado.barbershop.repositories;

import br.com.morgado.barbershop.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "select * from cliente as c ORDER BY c.data_cadastro DESC", nativeQuery = true)
    List<Cliente> listarClientesPorDataDecrescente();

    @Query(value = "select * from cliente as c where r.status = ?1 and DATE(r.data_cadastro) = ?2", nativeQuery = true)
    Cliente findByStatusAndDataCadastro(String status, Date dataCadastro);

}
