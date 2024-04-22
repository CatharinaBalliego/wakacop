package academy.wakanda.wakacop.sessao.domain;

import academy.wakanda.wakacop.sessao.application.api.ResultadoSessaoResponse;

public interface PublicadorResultadoSessao {
    void publica(ResultadoSessaoResponse resultadoSessaoResponse);
}
