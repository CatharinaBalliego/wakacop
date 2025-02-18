package academy.wakanda.wakacop.sessao.domain;

import academy.wakanda.wakacop.sessao.application.api.VotoRequest;
import academy.wakanda.wakacop.sessao.domain.Sessao;
import academy.wakanda.wakacop.sessao.domain.Voto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class VotoPauta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;
    private String cpfAssociado;
    private Voto opcaoVoto;
    private LocalDateTime momentoVoto;

    public VotoPauta(Sessao sessao, VotoRequest votoRequest) {
        this.sessao = sessao;
        this.cpfAssociado = votoRequest.getCpfAssociado();
        this.opcaoVoto = votoRequest.getOpcaoVoto();
        this.momentoVoto = LocalDateTime.now();
    }

    public UUID getIdSessao(){
        return this.sessao.getId();
    }

    public boolean opcaoIgual(Voto opcaoVoto){
        return this.opcaoVoto.equals(opcaoVoto);
    }
}
