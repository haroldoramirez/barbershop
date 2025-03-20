package br.com.morgado.barbershop.repositories;

import br.com.morgado.barbershop.models.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContatosRepository extends JpaRepository<Contato, Long> {

    @Query(value = "select * from contato as c ORDER BY c.data_cadastro DESC", nativeQuery = true)
    List<Contato> listarPorDataDecrescente();

}
