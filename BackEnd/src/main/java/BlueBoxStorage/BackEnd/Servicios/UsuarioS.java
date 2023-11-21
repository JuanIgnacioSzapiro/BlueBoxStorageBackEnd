package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import BlueBoxStorage.BackEnd.Repositorios.UsuarioR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioS {
    @Autowired
    private UsuarioR repositorio;

    public List<UsuarioNoAbstract> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody UsuarioNoAbstract modelo){
        UsuarioNoAbstract actualizado = new UsuarioNoAbstract();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        repositorio.save(actualizado);
    }

    public void update(@PathVariable Long id, @RequestBody UsuarioNoAbstract modelo){
        UsuarioNoAbstract actualizado = repositorio.findById(id).get();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }

    public UsuarioNoAbstract encontrarXnombreUsuario(String nombre_usuario){
        return repositorio.findByNombreUsuario(nombre_usuario);
    }


}
