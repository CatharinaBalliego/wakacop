package academy.wakanda.wakacop.sessao.application.service;

import academy.wakanda.wakacop.associado.application.service.AssociadoService;
import academy.wakanda.wakacop.pauta.application.service.PautaService;
import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.pauta.domain.VotoPauta;
import academy.wakanda.wakacop.sessao.application.api.*;
import academy.wakanda.wakacop.sessao.application.repository.SessaoRepository;
import academy.wakanda.wakacop.sessao.domain.Sessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SessaoApplicationService implements SessaoService {
    private final SessaoRepository sessaoRepository;
    private final PautaService pautaService;
    private final AssociadoService associadoService;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.debug("[start] SessaoApplicationService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        Sessao sessao = sessaoRepository.salva(new Sessao(sessaoAberturaRequest, pauta));
        log.debug("[finish] SessaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessao);
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest) {
        log.debug("[start] SessaoApplicationService - recebeVoto");
        Sessao sessao = sessaoRepository.buscarPorId(idSessao);
        VotoPauta voto = sessao.recebeVoto(votoRequest, associadoService);
        sessaoRepository.salva(sessao);
        log.debug("[finish] SessaoApplicationService - recebeVoto");
        return new VotoResponse(voto);
    }

    @Override
    public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
        log.debug("[start] SessaoApplicationService - obtemResultado");
        Sessao sessao = sessaoRepository.buscarPorId(idSessao);
        ResultadoSessaoResponse resultado = sessao.obtemResultado();
        sessaoRepository.salva(sessao);
        log.debug("[finish] SessaoApplicationService - obtemResultado");
        return resultado;
    }
}
