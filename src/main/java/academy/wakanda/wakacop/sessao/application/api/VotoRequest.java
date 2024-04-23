package academy.wakanda.wakacop.sessao.application.api;

import academy.wakanda.wakacop.sessao.domain.Voto;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class VotoRequest {
    private String cpfAssociado;
    private Voto opcaoVoto;
}
