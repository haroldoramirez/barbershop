package br.com.morgado.barbershop.api.resources;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/campanhas")
@CrossOrigin(origins="*")
public class CampanhasResources {

    //EXEMPLO DE UM ENDPOINT GET

    //GET
    @GetMapping
    public ResponseEntity<String> verificarDatas(@RequestParam(value = "numSerie", required = true) String numSerie,
                                                 @RequestParam(value = "numCupom", required = true) String numCupom) {

        Logger log = LoggerFactory.getLogger(CampanhasResources.class);

        LocalDate dataAtual = LocalDate.now();

        LocalDate dataTeste = LocalDate.of(dataAtual.getYear(), 9, 1);

        // Cria uma data representando o primeiro dia de agosto deste ano
        LocalDate dataAgosto = LocalDate.of(dataAtual.getYear(), 8, 1);

        // Cria uma data representando o primeiro dia de setembro deste ano
        LocalDate dataSetembro = LocalDate.of(dataAtual.getYear(), 9, 1);

        if (dataAgosto.equals(dataTeste)) {
            log.info("Validar a range da série para Agosto");
        }

        if (dataSetembro.equals(dataTeste)) {
            log.info("Validar a range da série para Setembro");
        }

        return ResponseEntity.ok("Ok - Mes de Agosto: " + dataAgosto.getMonthValue() + " Ano de Agosto: " + dataAgosto.getYear()
                + " Mes de Setembro: " + dataSetembro.getMonthValue() + " Ano de Setembro: " + dataSetembro.getYear()
                + " Data Atual: " + dataAtual.getDayOfMonth() + "-" + dataAtual.getMonthValue() + "-" + dataAtual.getYear());

    }

}
