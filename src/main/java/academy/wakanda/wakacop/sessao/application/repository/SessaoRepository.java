package academy.wakanda.wakacop.sessao.application.repository;

import academy.wakanda.wakacop.sessao.domain.Sessao;

import java.util.List;
import java.util.UUID;

public interface SessaoRepository {
    Sessao salva(Sessao sessaoAberturaRequest);

    Sessao buscarPorId(UUID idSessao);

    List<Sessao> buscaSessoesAbertas();
}
