package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.DepositoM;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface DepositoR extends JpaRepository<DepositoM, Long>{
    @Query(
            value="SELECT deposito.* FROM deposito INNER JOIN zona_depositos ON deposito.id_deposito = zona_depositos.id_depostio INNER JOIN zona ON zona_depositos.id_zona = zona.id_zona WHERE zona.id_zona = :idZona ;",
            nativeQuery=true
    )
    List<DepositoM> obtenerXzona(@Param("idZona") Long idZona);

    @Query(
            value="SELECT * FROM deposito WHERE deposito.id_deposito = (SELECT MAX(deposito.id_deposito) FROM deposito) ;",
            nativeQuery=true
    )
    DepositoM obtenerUltimoAgregado();

    DepositoM findByIdDeposito(Long id);

    @Modifying
    @Transactional
    @Query(
            value="DELETE FROM deposito WHERE deposito.id_deposito = :id_deposito ; ",
            nativeQuery=true
    )
    void deleteByIdDeposito(@Param("id_deposito")Long id_deposito);
}
