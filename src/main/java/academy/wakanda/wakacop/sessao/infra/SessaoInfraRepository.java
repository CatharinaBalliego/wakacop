package academy.wakanda.wakacop.sessao.infra;

import academy.wakanda.wakacop.sessao.application.repository.SessaoRepository;
import academy.wakanda.wakacop.sessao.domain.Sessao;
import academy.wakanda.wakacop.sessao.domain.StatusSessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class SessaoInfraRepository implements SessaoRepository {
    private final SessaoSpringDataJPARepository sessaoSpringDataJPARepository;
    @Override
    public Sessao salva(Sessao sessao) {
        log.debug("[start] SessaoInfraRepository - salva");
        Sessao sessaoSaved = sessaoSpringDataJPARepository.save(sessao);
        log.debug("[finish] SessaoInfraRepository - salva");
        return sessaoSaved;
    }

    @Override
    public Sessao buscarPorId(UUID idSessao) {
        log.debug("[start] SessaoInfraRepository - buscarSessaoPorId");
        Sessao sessao = sessaoSpringDataJPARepository.findById(idSessao)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada!"));
        log.debug("[finish] SessaoInfraRepository - buscarSessaoPorId");
        return sessao;
    }

    @Override
    public List<Sessao> buscaSessoesAbertas() {
        log.debug("[start] SessaoInfraRepository - buscaSessoesAbertas");
        List<Sessao> sessoes = sessaoSpringDataJPARepository.findByStatus(StatusSessaoVotacao.ABERTA);
        log.debug("[finish] SessaoInfraRepository - buscaSessoesAbertas");
        return  sessoes;
    }
}
