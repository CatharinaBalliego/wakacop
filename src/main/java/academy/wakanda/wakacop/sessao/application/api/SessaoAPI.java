package academy.wakanda.wakacop.sessao.application.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessao")
public interface SessaoAPI {

    @PostMapping("/abertura")
    @ResponseStatus(code = HttpStatus.CREATED)
    SessaoAberturaResponse abreSessaoVotacao(@RequestBody SessaoAberturaRequest sessaoAberturaRequest);
}
