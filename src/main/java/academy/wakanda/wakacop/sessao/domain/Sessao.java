package academy.wakanda.wakacop.sessao.domain;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.pauta.domain.VotoPauta;
import academy.wakanda.wakacop.sessao.application.api.VotoRequest;
import academy.wakanda.wakacop.sessao.application.api.SessaoAberturaRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private UUID idPauta;
    private Integer tempoDuracao;
    @Enumerated(EnumType.STRING)
    private StatusSessaoVotacao status;
    private LocalDateTime momentoAbertura;
    private LocalDateTime momentoEncerramento;

    @OneToMany(mappedBy = "sessao", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKey(name = "cpfAssociado")
    private Map<String, VotoPauta> votos;

    public Sessao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
        this.id = UUID.randomUUID();
        this.idPauta = pauta.getId();
        this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.status = StatusSessaoVotacao.ABERTA;
        this.momentoAbertura = LocalDateTime.now();
        this.momentoEncerramento = this.momentoAbertura.plusMinutes(this.tempoDuracao);
        votos = new HashMap<>();
    }

    public VotoPauta recebeVoto(VotoRequest votoRequest){
        validaAssociado(votoRequest.getCpfAssociado());
        validaSessaoAberta();
        VotoPauta votoPauta = new VotoPauta(this, votoRequest);
        this.votos.put(votoRequest.getCpfAssociado(), votoPauta);
        return votoPauta;
    }

    public void validaAssociado(String cpfAssociado){
        if(this.votos.containsKey(cpfAssociado))
            throw new RuntimeException("Associado já votou nessa sessão!");
    }

    public void validaSessaoAberta(){
        atualizaStatus();
        if(this.status.equals(StatusSessaoVotacao.FECHADA))
            throw new RuntimeException("Essa sessão está fechada!");
    }

    private void atualizaStatus() {
        if(this.status.equals(StatusSessaoVotacao.ABERTA)){
            if(LocalDateTime.now().isAfter(this.momentoEncerramento))
                fechaSessao();
        }
    }

    private void fechaSessao() {
        this.status = StatusSessaoVotacao.FECHADA;
    }
}
