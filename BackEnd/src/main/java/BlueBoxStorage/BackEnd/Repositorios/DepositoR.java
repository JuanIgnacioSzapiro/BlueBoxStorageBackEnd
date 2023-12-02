package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.DepositoM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositoR extends JpaRepository<DepositoM, Long>{
    @Query(
            value="SELECT deposito.* FROM `deposito` INNER JOIN zona_depositos ON deposito.idDeposito = zona_depositos.idDeposito INNER JOIN zona ON zona_depositos.idZona = zona.idZona WHERE zona.idZona = :idZona",
            nativeQuery=true
    )
    List<DepositoM> encontrarDepositosXIdZona(@Param("idZona") Long id);
}
