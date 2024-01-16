package Lista.dividas.Organiza.ai.repository;

import Lista.dividas.Organiza.ai.model.Dividas;
import Lista.dividas.Organiza.ai.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DividasRepository extends JpaRepository<Dividas, Long> {
    Page<Dividas> findAllByAtivoTrue (Pageable paginacao);

    @Query("SELECT d FROM Dividas d WHERE d.usuario.id = :idUsuario AND d.situacao = 'A_PAGAR'")
    List<Dividas> findUsuarioWithDividas(@Param("idUsuario") Long idUsuario);

}
