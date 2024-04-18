package academy.wakanda.wakacop.pauta.application.service;

import academy.wakanda.wakacop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.PautaResponse;

public interface PautaService {
    PautaResponse cadastraPauta(NovaPautaRequest novaPautaRequest);
}
