package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoR extends JpaRepository<EmpleadoM, Long>{
    EmpleadoM findByNombreUsuario(String nombre_usuario);

    Optional<EmpleadoM> findByIdUsuario(Long administrador);
}
