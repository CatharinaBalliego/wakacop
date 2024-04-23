package academy.wakanda.wakacop.sessao.application.api;

import academy.wakanda.wakacop.sessao.domain.VotoPauta;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class VotoResponse {
    private UUID idVoto;
    private UUID idSessao;
    private String cpfAssociado;
    private LocalDateTime momentoVoto;

    public VotoResponse(VotoPauta voto) {
        this.idVoto = voto.getId();
        this.idSessao = voto.getIdSessao();
        this.cpfAssociado = voto.getCpfAssociado();
        this.momentoVoto = voto.getMomentoVoto();
    }
}
