package academy.wakanda.wakacop.sessao.infra;

import academy.wakanda.wakacop.sessao.application.repository.SessaoRepository;
import academy.wakanda.wakacop.sessao.domain.Sessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
