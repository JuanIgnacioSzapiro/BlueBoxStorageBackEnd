package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.UsuarioM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioR extends JpaRepository <UsuarioM, Long> {
    Optional<UsuarioM> findByNombreUsuario(String nombre_usuario);
}
