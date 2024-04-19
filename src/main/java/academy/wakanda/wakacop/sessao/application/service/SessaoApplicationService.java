package academy.wakanda.wakacop.sessao.application.service;

import academy.wakanda.wakacop.pauta.application.service.PautaService;
import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.sessao.application.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessao.application.api.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessao.application.repository.SessaoRepository;
import academy.wakanda.wakacop.sessao.domain.Sessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class SessaoApplicationService implements SessaoService {
    private final SessaoRepository sessaoRepository;
    private final PautaService pautaService;
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoApplicationService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        Sessao sessao = sessaoRepository.salva(new Sessao(sessaoAberturaRequest, pauta));
        log.info("[finish] SessaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessao);
    }
}
