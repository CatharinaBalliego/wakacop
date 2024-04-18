package academy.wakanda.wakacop.pauta.application.repository;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import org.springframework.stereotype.Repository;

public interface PautaRepository {
    Pauta salva(Pauta pauta);
}
