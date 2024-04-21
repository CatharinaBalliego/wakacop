package academy.wakanda.wakacop.sessao.application.service;

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
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoApplicationService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        Sessao sessao = sessaoRepository.salva(new Sessao(sessaoAberturaRequest, pauta));
        log.info("[finish] SessaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessao);
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest) {
        log.info("[start] SessaoApplicationService - recebeVoto");
        Sessao sessao = sessaoRepository.buscarPorId(idSessao);
        VotoPauta voto = sessao.recebeVoto(votoRequest);
        sessaoRepository.salva(sessao);
        log.info("[finish] SessaoApplicationService - recebeVoto");
        return new VotoResponse(voto);
    }

    @Override
    public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
        log.info("[start] SessaoApplicationService - obtemResultado");
        Sessao sessao = sessaoRepository.buscarPorId(idSessao);
        ResultadoSessaoResponse resultado = sessao.obtemResultado();
        sessaoRepository.salva(sessao);
        log.info("[finish] SessaoApplicationService - obtemResultado");
        return resultado;
    }
}
