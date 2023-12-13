package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.SucursalZonaM;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SucursalZonaR extends JpaRepository<SucursalZonaM, Long> {
    @Modifying
    @Transactional
    @Query(
            value="DELETE FROM sucursal_zonas WHERE sucursal_zonas.id_zona = :id_zona ;",
            nativeQuery=true
    )
    void borrarXIdZona(@Param("id_zona") Long id_zona);
}
