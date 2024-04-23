package academy.wakanda.wakacop.sessao.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Optional;
import java.util.UUID;

@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SessaoAberturaRequest {
    @Getter
    @NotNull
    private UUID idPauta;
    private Integer tempoDuracao;

    public Optional<Integer> getTempoDuracao(){
        return Optional.of(this.tempoDuracao);
    }
}
