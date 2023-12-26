package Lista.dividas.Organiza.ai.repository;

import Lista.dividas.Organiza.ai.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
