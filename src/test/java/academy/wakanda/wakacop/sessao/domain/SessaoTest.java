package academy.wakanda.wakacop.sessao.domain;

import academy.wakanda.wakacop.associado.application.service.AssociadoService;
import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.sessao.application.api.ResultadoSessaoResponse;
import academy.wakanda.wakacop.sessao.application.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessao.application.api.VotoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

class SessaoTest {

    @Mock
    private AssociadoService associadoService;

    @Mock
    private PublicadorResultadoSessao publicadorResultadoSessao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSessaoAbertura() {
        Pauta pauta = Pauta.builder().build();
        SessaoAberturaRequest aberturaRequest = SessaoAberturaRequest.builder()
                .idPauta(UUID.randomUUID())
                .tempoDuracao(1)
                .build();

        Sessao sessaoVotacao = new Sessao(aberturaRequest, pauta);

        assertEquals(pauta.getId(), sessaoVotacao.getIdPauta());
        assertEquals(1, sessaoVotacao.getTempoDuracao());
        assertNotNull(sessaoVotacao.getMomentoAbertura());
        assertNotNull(sessaoVotacao.getMomentoEncerramento());
        assertEquals(StatusSessaoVotacao.ABERTA, sessaoVotacao.getStatus());
        assertNotNull(sessaoVotacao.getVotos());
        assertTrue(sessaoVotacao.getVotos().isEmpty());
    }

    @Test
    void testRecebeVoto() {
        Pauta pauta = Pauta.builder().build();
        SessaoAberturaRequest aberturaRequest = SessaoAberturaRequest.builder()
                .idPauta(UUID.randomUUID())
                .tempoDuracao(1)
                .build();

        Sessao sessaoVotacao = new Sessao(aberturaRequest, pauta);

        VotoRequest votoRequest = VotoRequest.builder()
                .cpfAssociado("123456789")
                .opcaoVoto(Voto.SIM)
                .build();

        VotoPauta votoPauta = sessaoVotacao.recebeVoto(votoRequest, associadoService, publicadorResultadoSessao);

        assertNotNull(votoPauta);
        assertEquals(sessaoVotacao, votoPauta.getSessao());
        assertEquals(votoRequest.getCpfAssociado(), votoPauta.getCpfAssociado());
        assertEquals(votoRequest.getOpcaoVoto(), votoPauta.getOpcaoVoto());
        assertNotNull(votoPauta.getMomentoVoto());
        assertTrue(sessaoVotacao.getVotos().containsKey(votoRequest.getCpfAssociado()));
    }

    @Test
    void testValidaAssociado() {
        Pauta pauta = Pauta.builder().build();
        SessaoAberturaRequest aberturaRequest = SessaoAberturaRequest.builder()
                .idPauta(UUID.randomUUID())
                .tempoDuracao(1)
                .build();

        Sessao sessaoVotacao = new Sessao(aberturaRequest, pauta);

        VotoRequest votoRequest = VotoRequest.builder()
                .cpfAssociado("123456789")
                .build();

        doNothing().when(associadoService).validaCpfAssociado(votoRequest.getCpfAssociado());

        sessaoVotacao.validaAssociado(votoRequest.getCpfAssociado(), associadoService);
    }

    @Test
    void testValidaVotoDuplicado() {
        Pauta pauta = Pauta.builder().build();
        SessaoAberturaRequest aberturaRequest = SessaoAberturaRequest.builder()
                .idPauta(UUID.randomUUID())
                .tempoDuracao(1)
                .build();

        Sessao sessaoVotacao = new Sessao(aberturaRequest, pauta);

        VotoRequest votoRequest = VotoRequest.builder()
                .cpfAssociado("123456789")
                .build();

        sessaoVotacao.recebeVoto(votoRequest, associadoService, publicadorResultadoSessao);

        assertThrows(RuntimeException.class, () -> sessaoVotacao.validaVotoDuplicado(votoRequest.getCpfAssociado()));
    }

    @Test
    void testObtemResultado() {
        Pauta pauta = Pauta.builder().build();
        SessaoAberturaRequest aberturaRequest = SessaoAberturaRequest.builder()
                .idPauta(UUID.randomUUID())
                .tempoDuracao(1)
                .build();

        Sessao sessaoVotacao = new Sessao(aberturaRequest, pauta);

        ResultadoSessaoResponse resultadoSessaoResponse = sessaoVotacao.obtemResultado(publicadorResultadoSessao);

        assertNotNull(resultadoSessaoResponse);
        assertEquals(sessaoVotacao.getId(), resultadoSessaoResponse.getIdSessao());
        assertEquals(sessaoVotacao.getIdPauta(), resultadoSessaoResponse.getIdPauta());
        assertEquals(sessaoVotacao.getStatus(), resultadoSessaoResponse.getStatus());
        assertEquals(sessaoVotacao.getMomentoAbertura(), resultadoSessaoResponse.getMomentoAbertura());
        assertEquals(sessaoVotacao.getMomentoEncerramento(), resultadoSessaoResponse.getMomentoEncerramento());
        assertEquals(sessaoVotacao.getTotalVotos(), resultadoSessaoResponse.getTotalVotos());
        assertEquals(sessaoVotacao.getTotalSim(), resultadoSessaoResponse.getTotalSim());
        assertEquals(sessaoVotacao.getTotalNao(), resultadoSessaoResponse.getTotalNao());
    }

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