package academy.wakanda.wakacop.sessao.application.api;

import academy.wakanda.wakacop.sessao.domain.Sessao;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class SessaoAberturaResponse {
    UUID sessaoId;

    public SessaoAberturaResponse(Sessao sessao) {
        this.sessaoId = sessao.getId();
    }
}
