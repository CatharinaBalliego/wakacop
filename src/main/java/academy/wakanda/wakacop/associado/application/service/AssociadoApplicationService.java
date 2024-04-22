package academy.wakanda.wakacop.associado.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AssociadoApplicationService implements AssociadoService {
    @Override
    public void validaCpfAssociado(String cpfAssociado) {
        log.info("[start] AssociadoApplicationService - validaCpfAssociado");
        log.info("[finish] AssociadoApplicationService - validaCpfAssociado");

    }
}
