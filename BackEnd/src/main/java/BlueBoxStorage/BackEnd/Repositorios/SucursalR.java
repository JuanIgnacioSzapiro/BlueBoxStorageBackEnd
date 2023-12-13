package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.SucursalM;
import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface SucursalR extends JpaRepository<SucursalM, Long> {
    @Query(
            value="SELECT sucursal.* FROM sucursal INNER JOIN sucursal_zonas ON sucursal.id_sucursal = sucursal_zonas.id_sucursal INNER JOIN zona ON sucursal_zonas.id_zona = zona.id_zona WHERE zona.id_zona = :idZona ;",
            nativeQuery=true
    )
    SucursalM obtenerSucursalPerteneciente(@Param("idZona") Long idZona);

    SucursalM findByIdSucursal(Long id);

    @Modifying
    @Transactional
    @Query(
            value="DELETE FROM sucursal WHERE sucursal.id_sucursal = :id_sucursal ; ",
            nativeQuery=true
    )
    void deleteByIdSucursal(@Param("id_sucursal")Long id_sucursal);
}
