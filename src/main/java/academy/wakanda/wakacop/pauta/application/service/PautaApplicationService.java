package academy.wakanda.wakacop.pauta.application.service;

import academy.wakanda.wakacop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.PautaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PautaApplicationService implements PautaService {
    @Override
    public PautaResponse cadastraPauta(NovaPautaRequest novaPautaRequest) {
        log.info("[start] PautaApplicationService - cadastraPauta");
        log.info("[novaPauta] {}", novaPautaRequest);
        log.info("[finish] PautaApplicationService - cadastraPauta");
        return null;

    }
}
