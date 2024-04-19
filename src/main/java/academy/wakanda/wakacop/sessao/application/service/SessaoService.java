package academy.wakanda.wakacop.sessao.application.service;

import academy.wakanda.wakacop.sessao.application.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessao.application.api.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessao.application.api.VotoRequest;
import academy.wakanda.wakacop.sessao.application.api.VotoResponse;

import java.util.UUID;

public interface SessaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);

    VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest);
}
