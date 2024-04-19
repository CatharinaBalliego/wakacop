package academy.wakanda.wakacop.sessao.infra;

import academy.wakanda.wakacop.sessao.application.repository.SessaoRepository;
import academy.wakanda.wakacop.sessao.domain.Sessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class SessaoInfraRepository implements SessaoRepository {
    private final SessaoSpringDataJPARepository sessaoSpringDataJPARepository;
    @Override
    public Sessao salva(Sessao sessao) {
        log.info("[start] SessaoInfraRepository - salva");
        Sessao sessaoSaved = sessaoSpringDataJPARepository.save(sessao);
        log.info("[finish] SessaoInfraRepository - salva");
        return sessaoSaved;
    }

    @Override
    public Sessao buscarPorId(UUID idSessao) {
        log.info("[start] SessaoInfraRepository - buscarSessaoPorId");
        Sessao sessao = sessaoSpringDataJPARepository.findById(idSessao)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada!"));
        log.info("[finish] SessaoInfraRepository - buscarSessaoPorId");
        return sessao;
    }
}
