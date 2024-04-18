package academy.wakanda.wakacop.pauta.application.api;


import academy.wakanda.wakacop.pauta.application.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PautaController implements PautaAPI {
    private final PautaService pautaService;
    @Override
    public PautaResponse cadastraPauta(@RequestBody NovaPautaRequest novaPautaRequest) {
        log.info("[start] PautaApplicationAPI - cadastraPauta");
        PautaResponse pautaResponse = pautaService.cadastraPauta(novaPautaRequest);
        log.info("[finish] PautaApplicationAPI - cadastraPauta");
        return pautaResponse;

    }
}
