package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioR extends JpaRepository<UsuarioNoAbstract, Long> {
    @Query(
            value="SELECT usuario.dtype FROM usuario WHERE usuario.nombre_usuario = :nombre_usuario ;",
            nativeQuery=true
    )
    String encontrarTipoXnombre(@Param("nombre_usuario") String nombre_usuario);

    @Query(
            value="SELECT usuario.* FROM usuario WHERE usuario.nombre_usuario = :nombre_usuario ;",
            nativeQuery=true
    )
    UsuarioNoAbstract encontrarXnombre_usuario(@Param("nombre_usuario") String nombre_usuario);
}
