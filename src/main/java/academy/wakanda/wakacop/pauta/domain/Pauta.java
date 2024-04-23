package academy.wakanda.wakacop.pauta.domain;

import academy.wakanda.wakacop.pauta.application.api.NovaPautaRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String titulo;
    private String descricao;
    private UUID idAssociadoAutor;
    private LocalDateTime dataCriacao;

    public Pauta(NovaPautaRequest novaPautaRequest) {
        this.id = UUID.randomUUID();
        this.titulo = novaPautaRequest.getTitulo();
        this.descricao = novaPautaRequest.getDescricao();
        this.idAssociadoAutor = novaPautaRequest.getIdAssociadoAutor();
        this.dataCriacao = LocalDateTime.now();
    }
}
