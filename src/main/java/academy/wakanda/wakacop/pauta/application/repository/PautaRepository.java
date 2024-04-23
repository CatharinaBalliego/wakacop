package academy.wakanda.wakacop.pauta.application.repository;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface PautaRepository {
    Pauta salva(Pauta pauta);

    Pauta getPautaPorId(UUID idPauta);
}
