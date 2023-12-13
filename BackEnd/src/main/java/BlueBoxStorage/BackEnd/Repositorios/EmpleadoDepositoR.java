package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoDepositoM;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EmpleadoDepositoR extends JpaRepository<EmpleadoDepositoM, Long> {
    @Query(
            value="SELECT empleado_depostio.* FROM empleado_depostio WHERE empleado_depostio.id_usuario = :id_usuario ;",
            nativeQuery=true
    )
    List<EmpleadoDepositoM> encontrarXidUsuario(@Param("id_usuario") Long id_usuario);

    @Modifying
    @Transactional
    @Query(
            value="DELETE FROM empleado_depostio WHERE empleado_depostio.id_empleado_deposito = :id_empleado_deposito ; ",
            nativeQuery=true
    )
    void deleteByIdEmpleadoDeposito(@Param("id_empleado_deposito")Long id_empleado_deposito);
}