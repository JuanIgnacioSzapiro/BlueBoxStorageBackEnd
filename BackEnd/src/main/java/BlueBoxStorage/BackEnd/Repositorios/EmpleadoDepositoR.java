package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoDepositoM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoDepositoR extends JpaRepository<EmpleadoDepositoM, Long> {
    @Query(
            value="SELECT empleado_depostio.* FROM empleado_depostio WHERE empleado_depostio.id_usuario = :id_usuario ;",
            nativeQuery=true
    )
    List<EmpleadoDepositoM> encontrarXidUsuario(@Param("id_usuario") Long id_usuario);
}