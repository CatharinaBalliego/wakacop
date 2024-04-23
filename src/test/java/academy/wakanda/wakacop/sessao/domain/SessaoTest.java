package academy.wakanda.wakacop.sessao.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SessaoTest {

    @Test
    public void deveFecharQuandoStatusAbertaEMomentoEncerramentoEstiverNoPassado(){
        Sessao sessao = buildSessao();
        PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
        sessao.atualizaStatus(publicador);

        assertEquals(StatusSessaoVotacao.FECHADA, sessao.getStatus());
    }

    @Test
    public void deveFicarAbertaQuandoStatusAbertaEMomentoEncerramentoEstiverNoFuturo(){
        Sessao sessao = buildSessaoFuturo();
        PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
        sessao.atualizaStatus(publicador);

        assertEquals(StatusSessaoVotacao.ABERTA, sessao.getStatus());
    }

    @Test
    public void deveFecharSessaoQuandoChamarMetodoFechaSessao(){
        Sessao sessao = buildSessao();
        PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
        sessao.fechaSessao(publicador);

        assertEquals(StatusSessaoVotacao.FECHADA, sessao.getStatus());
    }





    private Sessao buildSessao(){
        return Sessao.builder()
                .id(UUID.randomUUID())
                .idPauta(UUID.randomUUID())
                .votos(getVotos())
                .momentoAbertura(LocalDateTime.of(2024,1,1,1,1))
                .momentoEncerramento(LocalDateTime.of(2024,1,1,1,2))
                .status(StatusSessaoVotacao.ABERTA)
                .build();
    }
    private Sessao buildSessaoFuturo(){
        return Sessao.builder()
                .id(UUID.randomUUID())
                .idPauta(UUID.randomUUID())
                .votos(getVotos())
                .momentoAbertura(LocalDateTime.of(2024,1,1,1,1))
                .momentoEncerramento(LocalDateTime.MAX)
                .status(StatusSessaoVotacao.ABERTA)
                .build();
    }
    private Map<String, VotoPauta> getVotos(){
        return Map.of("15648957854", VotoPauta.builder().opcaoVoto(Voto.SIM).cpfAssociado("15648957854").build(),
                "11456824569", VotoPauta.builder().opcaoVoto(Voto.NAO).cpfAssociado("11456824569").build());
    }

}