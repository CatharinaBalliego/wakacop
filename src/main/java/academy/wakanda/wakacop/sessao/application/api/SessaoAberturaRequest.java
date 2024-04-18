package academy.wakanda.wakacop.sessao.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;
import java.util.UUID;

@ToString
public class SessaoAberturaRequest {
    @Getter
    @NotNull
    private UUID idPauta;
    private Integer tempoDuracao;

    public Optional<Integer> getTempoDuracao(){
        return Optional.of(this.tempoDuracao);
    }
}
