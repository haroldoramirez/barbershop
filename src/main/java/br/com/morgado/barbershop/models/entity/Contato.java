package br.com.morgado.barbershop.models.entity;

import br.com.morgado.barbershop.models.enums.StatusContato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 80)
    private String email;

    @Column(nullable = false, length = 50)
    private String assunto;

    @Column(nullable = false, length = 400)
    private String mensagem;

    @Column(name = "data_cadastro", updatable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private StatusContato status;

}
