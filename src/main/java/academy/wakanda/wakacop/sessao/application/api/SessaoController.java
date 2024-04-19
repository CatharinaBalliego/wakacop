package academy.wakanda.wakacop.sessao.application.api;

import academy.wakanda.wakacop.sessao.application.service.SessaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Log4j2
public class SessaoController implements SessaoAPI {
    private final SessaoService sessaoService;
    @Override
    public SessaoAberturaResponse abreSessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoController - abreSessaoVotacao");
        SessaoAberturaResponse sessaoAberturaResponse = sessaoService.abreSessao(sessaoAberturaRequest);
        log.info("[finish] SessaoController - abreSessaoVotacao");
        return sessaoAberturaResponse;
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest) {
        log.info("[start] SessaoController - recebeVoto");
        log.info("[idSessao] {}", idSessao);
        VotoResponse votoResponse = sessaoService.recebeVoto(idSessao, votoRequest);
        log.info("[finish] SessaoController - recebeVoto");
        return votoResponse;
    }
}
