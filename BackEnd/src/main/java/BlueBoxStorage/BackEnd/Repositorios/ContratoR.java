package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.ContratoM;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
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

    ContratoM findByIdContrato(Long id);

    @Modifying
    @Transactional
    @Query(
            value="DELETE FROM contrato WHERE contrato.id_contrato = :id_contrato ; ",
            nativeQuery=true
    )
    void deleteByIdContrato(@Param("id_contrato")Long id_contrato);
}
