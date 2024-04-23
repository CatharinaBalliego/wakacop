package academy.wakanda.wakacop.sessao.infra;

import academy.wakanda.wakacop.sessao.domain.Sessao;
import academy.wakanda.wakacop.sessao.domain.StatusSessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SessaoSpringDataJPARepository extends JpaRepository<Sessao, UUID> {
    List<Sessao> findByStatus(StatusSessaoVotacao statusSessaoVotacao);
}
