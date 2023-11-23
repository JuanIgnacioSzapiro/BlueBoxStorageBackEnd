package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.ClienteM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteR extends JpaRepository<ClienteM, Long>{
    ClienteM findByNombreUsuario(String nombre_usuario);
}
