package br.com.morgado.barbershop.services.impl;

import br.com.morgado.barbershop.models.entity.Cliente;
import br.com.morgado.barbershop.models.enums.StatusCliente;
import br.com.morgado.barbershop.repositories.ClientesRepository;
import br.com.morgado.barbershop.services.ClientesService;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ClientesServiceImpl implements ClientesService {

    private static final String NOME_PADRAO = "Fulano";

    private final ClientesRepository clientesRepository;

    public ClientesServiceImpl(ClientesRepository clientesRepository) {

        super();
        this.clientesRepository = clientesRepository;

    }

    @Override
    public List<Cliente> listarClientesPorDataDecrescente() {
        return clientesRepository.listarClientesPorDataDecrescente();
    }

    @Override
    @Transactional
    public Cliente salvarCliente(Cliente cliente) {

        validarCliente(cliente);

        cliente.setDataCadastro(LocalDateTime.now());

        return clientesRepository.save(cliente);

    }

    @Override
    public void validarCliente(Cliente cliente) {
        if (StringUtils.isBlank(cliente.getNome())) {
            cliente.setNome(NOME_PADRAO);
        }
    }

    private static Date toDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    private static String formatarLocalDateTime(LocalDateTime localDateTime, String formato) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return localDateTime.format(formatter);
    }

    private static String formatarStatus(StatusCliente status) {

        String textoStatus = "";

        textoStatus = switch (status) {
            case ATIVO -> "Visita na casa da Diana";
            case INATIVO -> "Visita na casa do Liam";
            default -> "Passeio";
        };

        return textoStatus;

    }

}
