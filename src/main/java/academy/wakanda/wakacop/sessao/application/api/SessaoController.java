package academy.wakanda.wakacop.sessao.application.api;

import academy.wakanda.wakacop.sessao.application.service.SessaoService;
import academy.wakanda.wakacop.sessao.domain.PublicadorResultadoSessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Log4j2
public class SessaoController implements SessaoAPI {
    private final SessaoService sessaoService;
    private final PublicadorResultadoSessao publicadorResultadoSessao;
    @Override
    public SessaoAberturaResponse abreSessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.debug("[start] SessaoController - abreSessaoVotacao");
        SessaoAberturaResponse sessaoAberturaResponse = sessaoService.abreSessao(sessaoAberturaRequest);
        log.debug("[finish] SessaoController - abreSessaoVotacao");
        return sessaoAberturaResponse;
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest) {
        log.debug("[start] SessaoController - recebeVoto");
        log.debug("[idSessao] {}", idSessao);
        VotoResponse votoResponse = sessaoService.recebeVoto(idSessao, votoRequest, publicadorResultadoSessao);
        log.debug("[finish] SessaoController - recebeVoto");
        return votoResponse;
    }

    @Override
    public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
        log.debug("[start] SessaoController - obtemResultado");
        ResultadoSessaoResponse resultado = sessaoService.obtemResultado(idSessao);
        log.debug("[finish] SessaoController - obtemResultado");
        return resultado;
    }
}
