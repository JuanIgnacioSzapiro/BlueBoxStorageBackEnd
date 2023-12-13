package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.ClienteM;
import BlueBoxStorage.BackEnd.Servicios.ClienteS;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface ClienteR extends JpaRepository<ClienteM, Long>{
    ClienteM findByNombreUsuario(String nombre_usuario);

    ClienteM findByIdUsuario(Long id);

    @Modifying
    @Transactional
    @Query(
            value="DELETE FROM usuario WHERE usuario.id_usuario = :id_usuario ; ",
            nativeQuery=true
    )
    void deleteByIdUsuario(@Param("id_usuario")Long id_usuario);
}
