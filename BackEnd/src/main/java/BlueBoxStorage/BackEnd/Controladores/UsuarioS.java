package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioS {

    @Autowired
    private UsuarioR repositorio;

    public String encontrarTipoXnombre(String nombreUsuario) {
        return repositorio.encontrarTipoXnombre(nombreUsuario);
    }

    public UsuarioNoAbstract encontrarXnombre_usuario(String nombre_usuario) {
        return repositorio.encontrarXnombre_usuario(nombre_usuario);
    }
}
