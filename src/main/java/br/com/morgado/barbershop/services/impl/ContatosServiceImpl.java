package br.com.morgado.barbershop.services.impl;

import br.com.morgado.barbershop.exceptions.RegraNegocioException;
import br.com.morgado.barbershop.models.entity.Contato;
import br.com.morgado.barbershop.repositories.ContatosRepository;
import br.com.morgado.barbershop.services.ContatosService;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class ContatosServiceImpl implements ContatosService {

    private final ContatosRepository contatosRepository;

    public ContatosServiceImpl(ContatosRepository contatosRepository) {

        super();
        this.contatosRepository = contatosRepository;

    }

    @Override
    @Transactional
    public Contato salvar(Contato contato) {

        validar(contato);

        contato.setDataCadastro(LocalDateTime.now());

        return contatosRepository.save(contato);

    }

    @Override
    public void validar(Contato contato) {
        if (StringUtils.isBlank(contato.getNome())) {
            throw new RegraNegocioException("O nome veio vazio");
        }
    }

    @Override
    public List<Contato> listarPorDataDecrescente() {
        return contatosRepository.listarPorDataDecrescente();
    }

}
