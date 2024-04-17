package academy.wakanda.wakacop.pauta.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PautaAPI {
    @PostMapping
    PautaResponse cadastraPauta(@RequestBody NovaPautaRequest novaPautaRequest);
}
