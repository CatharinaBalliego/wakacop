package academy.wakanda.wakacop.sessao.application.service;

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
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoApplicationService - abreSessao");
        Sessao sessao = sessaoRepository.salva(new Sessao(sessaoAberturaRequest));
        log.info("[finish] SessaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessao);
    }
}
