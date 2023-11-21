package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Modelos.RolM;
import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import BlueBoxStorage.BackEnd.Repositorios.RolR;
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

    @Autowired
    private RolR rolR;

    public List<UsuarioNoAbstract> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody UsuarioNoAbstract modelo){
        RolM rolM = rolR.findByAutoridad(modelo.getAutoridades().toString()).get();

        Set<RolM> autoridades = new HashSet<>();
        autoridades.add(rolM);

        UsuarioNoAbstract actualizado = new UsuarioNoAbstract();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        actualizado.setAutoridades(autoridades);
        repositorio.save(actualizado);
    }

    public void update(@PathVariable Long id, @RequestBody UsuarioNoAbstract modelo){
        UsuarioNoAbstract actualizado = repositorio.findById(id).get();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        actualizado.setAutoridades(modelo.getAutoridades());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }

    public UsuarioNoAbstract encontrarXnombreUsuario(String nombre_usuario){
        return repositorio.findByNombreUsuario(nombre_usuario);
    }


}
