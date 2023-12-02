package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZonaR extends JpaRepository<ZonaM, Long>{
    @Query(
            value="SELECT zona.* FROM `zona` INNER JOIN sucursal_zonas ON zona.id_zona = sucursal_zonas.id_zona INNER JOIN sucursal ON sucursal_zonas.id_sucursal = sucursal.id_sucursal WHERE sucursal.id_sucursal = :idSucursal",
            nativeQuery=true
    )
    List<ZonaM> encontrarZonasXIdSucursal(@Param("idSucursal") Long idSucursal);
}
