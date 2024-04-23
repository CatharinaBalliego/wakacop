package academy.wakanda.wakacop.pauta.application.api;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class PautaResponse {
    private UUID id;

    public PautaResponse(Pauta pauta) {
        this.id = pauta.getId();
    }
}
