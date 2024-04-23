package academy.wakanda.wakacop.associado.application.service;

import academy.wakanda.wakacop.associado.application.infra.client.ConsultaCpfResponse;
import academy.wakanda.wakacop.associado.application.infra.client.SerproClientFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AssociadoApplicationService implements AssociadoService {
    private final SerproClientFeign serproClientFeign;
    @Override
    public void validaCpfAssociado(String cpfAssociado) {
        log.debug("[start] AssociadoApplicationService - validaCpfAssociado");
        log.debug("[TOKEN] {}", TOKEN);
        ConsultaCpfResponse consultaCPFResponse = serproClientFeign.consultaCPF(TOKEN, cpfAssociado);
        valida(consultaCPFResponse);
        log.debug("[finish] AssociadoApplicationService - validaCpfAssociado");
    }
    private void valida(ConsultaCpfResponse consultaCpfResponse){
        if(consultaCpfResponse.isInvalid())
            throw new RuntimeException("Cpf associado não é apto para votar!");
    }

    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";
}
