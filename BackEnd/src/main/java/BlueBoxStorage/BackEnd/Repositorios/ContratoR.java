package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.ContratoM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratoR extends JpaRepository<ContratoM, Long>{
    @Query(
            value="SELECT contrato.* FROM contrato WHERE contrato.id_usuario = :id_usuario ; ",
            nativeQuery=true
    )
    List<ContratoM> obtenerDeIdCliente(@Param("id_usuario") Long id_usuario);
    @Query(
            value="SELECT contrato.* FROM contrato INNER JOIN empleado_depostio ON contrato.id_deposito = empleado_depostio.id_deposito WHERE empleado_depostio.id_usuario = :id_empleado ; ",
            nativeQuery=true
    )
    List<ContratoM> obtenerDeIdEmpleado(@Param("id_empleado") Long id_empleado);
}
