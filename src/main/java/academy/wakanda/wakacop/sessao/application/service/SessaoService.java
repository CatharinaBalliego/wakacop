package academy.wakanda.wakacop.sessao.application.service;

import academy.wakanda.wakacop.sessao.application.api.*;
import academy.wakanda.wakacop.sessao.domain.PublicadorResultadoSessao;

import java.util.UUID;

public interface SessaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);

    VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest, PublicadorResultadoSessao publicadorResultadoSessao);

    ResultadoSessaoResponse obtemResultado(UUID idSessao);
}
