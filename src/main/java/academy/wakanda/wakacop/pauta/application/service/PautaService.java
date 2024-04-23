package academy.wakanda.wakacop.pauta.application.service;

import academy.wakanda.wakacop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.PautaResponse;
import academy.wakanda.wakacop.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaService {
    PautaResponse cadastraPauta(NovaPautaRequest novaPautaRequest);

    Pauta getPautaPorId(UUID idPauta);
}
