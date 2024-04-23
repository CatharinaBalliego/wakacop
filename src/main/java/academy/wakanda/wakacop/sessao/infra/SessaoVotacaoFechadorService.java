package academy.wakanda.wakacop.sessao.infra;

import academy.wakanda.wakacop.sessao.application.repository.SessaoRepository;
import academy.wakanda.wakacop.sessao.domain.PublicadorResultadoSessao;
import academy.wakanda.wakacop.sessao.domain.Sessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class SessaoVotacaoFechadorService {
    private final SessaoRepository sessaoRepository;
    private final PublicadorResultadoSessao publicador;

    @Scheduled(cron = "0 * * * * ?")
    public void fechaSessoesEncerradas(){
        log.debug("[start] SessaoVotacaoFechadorService - fechaSessoesEncerradas");
        List<Sessao> sessoesAberta = sessaoRepository.buscaSessoesAbertas();
        sessoesAberta.forEach(sessao -> {
            sessao.obtemResultado(publicador);
            sessaoRepository.salva(sessao);
        });
        log.debug("[finish] SessaoVotacaoFechadorService - fechaSessoesEncerradas");
    }
}
