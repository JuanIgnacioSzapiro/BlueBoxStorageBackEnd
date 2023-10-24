package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import BlueBoxStorage.BackEnd.Repositorios.UsuarioR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioS {
    @Autowired
    private UsuarioR repositorio;

    public List<UsuarioNoAbstract> obtenerTodos(){
        return repositorio.findAll();
    }

    public UsuarioNoAbstract encontrarXnombreUsuario(String nombre_usuario){
        return repositorio.findByNombreUsuario(nombre_usuario);
    }
}
