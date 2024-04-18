package academy.wakanda.wakacop.sessao.application.service;

import academy.wakanda.wakacop.sessao.application.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessao.application.api.SessaoAberturaResponse;

public interface SessaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
}
