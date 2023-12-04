package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.ZonaDepositoM;
import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaDepositoR extends JpaRepository<ZonaDepositoM, Long> {
    @Modifying
    @Transactional
    @Query(
            value="DELETE FROM zona_depositos WHERE zona_depositos.id_depostio = :id_deposito ; ",
            nativeQuery=true
    )
    void borrarXIdDeposito(@Param("id_deposito")Long id_deposito);
}
