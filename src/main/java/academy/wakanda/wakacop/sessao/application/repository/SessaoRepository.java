package academy.wakanda.wakacop.sessao.application.repository;

import academy.wakanda.wakacop.sessao.domain.Sessao;

public interface SessaoRepository {
    Sessao salva(Sessao sessaoAberturaRequest);
}
