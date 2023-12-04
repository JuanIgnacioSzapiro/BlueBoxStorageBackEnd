package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.DepositoM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositoR extends JpaRepository<DepositoM, Long>{
}
