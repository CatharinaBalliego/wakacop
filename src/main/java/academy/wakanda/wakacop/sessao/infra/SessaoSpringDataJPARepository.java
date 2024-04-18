package academy.wakanda.wakacop.sessao.infra;

import academy.wakanda.wakacop.sessao.domain.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessaoSpringDataJPARepository extends JpaRepository<Sessao, UUID> {
}
