package BlueBoxStorage.BackEnd.Repositorios;

import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioR extends JpaRepository <UsuarioNoAbstract, Long> {
    UsuarioNoAbstract findByNombreUsuario(String nombre_usuario);
}
