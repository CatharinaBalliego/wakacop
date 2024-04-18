package academy.wakanda.wakacop.pauta.application.api;

import academy.wakanda.wakacop.pauta.domain.Pauta;

import java.util.UUID;

public class PautaResponse {
    private UUID id;

    public PautaResponse(Pauta pauta) {
        this.id = pauta.getId();
    }
}
