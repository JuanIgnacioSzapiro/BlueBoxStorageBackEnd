package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Repositorios.EmpleadoR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmpleadoS {
    @Autowired
    private EmpleadoR repositorio;

    public List<EmpleadoM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody EmpleadoM modelo){
        EmpleadoM actualizado = new EmpleadoM();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        actualizado.isAdministrador();
        actualizado.isEmpleado();
        actualizado.setCodigo(modelo.getCodigo());
        actualizado.setEspecialidad(modelo.getEspecialidad());
        repositorio.save(actualizado);
    }

    public void update(@PathVariable Long id, @RequestBody EmpleadoM modelo){
        EmpleadoM actualizado = repositorio.findById(id).get();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        actualizado.isAdministrador();
        actualizado.isEmpleado();
        actualizado.setCodigo(modelo.getCodigo());
        actualizado.setEspecialidad(modelo.getEspecialidad());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }
}
