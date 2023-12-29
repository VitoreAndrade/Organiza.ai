package Lista.dividas.Organiza.ai.repository;

import Lista.dividas.Organiza.ai.model.Dividas;
import Lista.dividas.Organiza.ai.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividasRepository extends JpaRepository<Dividas, Long> {
    Page<Dividas> findAllByAtivoTrue (Pageable paginacao);
}
