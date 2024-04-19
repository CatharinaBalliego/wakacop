package academy.wakanda.wakacop.sessao.domain;

import academy.wakanda.wakacop.sessao.application.api.SessaoAberturaRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@ToString
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private UUID idPauta;
    private Integer tempoDuracao;
    @Enumerated
    private StatusSessaoVotacao status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEncerramento;


    public Sessao(SessaoAberturaRequest sessaoAberturaRequest) {
        this.id = UUID.randomUUID();
        this.idPauta = sessaoAberturaRequest.getIdPauta();
        this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.status = StatusSessaoVotacao.ABERTA;
        this.dataCriacao = LocalDateTime.now();
        this.dataEncerramento = this.dataCriacao.plusMinutes(this.tempoDuracao);
    }

}
