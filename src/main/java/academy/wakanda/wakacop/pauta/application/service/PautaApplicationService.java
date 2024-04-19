package academy.wakanda.wakacop.pauta.application.service;

import academy.wakanda.wakacop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.PautaResponse;
import academy.wakanda.wakacop.pauta.application.repository.PautaRepository;
import academy.wakanda.wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PautaApplicationService implements PautaService {
    private final PautaRepository pautaRepository;
    @Override
    public PautaResponse cadastraPauta(NovaPautaRequest novaPautaRequest) {
        log.info("[start] PautaApplicationService - cadastraPauta");
        log.info("[novaPauta] {}", novaPautaRequest);
        Pauta pauta = pautaRepository.salva(new Pauta(novaPautaRequest));
        log.info("[finish] PautaApplicationService - cadastraPauta");
        return new PautaResponse(pauta);

    }

    @Override
    public Pauta getPautaPorId(UUID idPauta) {
        log.info("[start] PautaApplicationRepository - getPautaPorId");
        Pauta pauta = pautaRepository.getPautaPorId(idPauta);
        log.info("[finish] PautaApplicationRepository - getPautaPorId");
        return pauta;
    }
}
