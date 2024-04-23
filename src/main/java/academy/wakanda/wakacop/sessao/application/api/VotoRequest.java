package academy.wakanda.wakacop.sessao.application.api;

import academy.wakanda.wakacop.sessao.domain.Voto;
import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class VotoRequest {
    private String cpfAssociado;
    private Voto opcaoVoto;
}
