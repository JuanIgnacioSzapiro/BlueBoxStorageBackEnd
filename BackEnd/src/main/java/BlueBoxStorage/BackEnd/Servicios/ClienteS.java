package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.ClienteM;
import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import BlueBoxStorage.BackEnd.Repositorios.ClienteR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClienteS {
    @Autowired
    private ClienteR repositorio;

    public List<ClienteM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody ClienteM modelo){
        ClienteM actualizado = new ClienteM();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        actualizado.setCliente(modelo.isCliente());
        actualizado.setPendiente(modelo.isPendiente());
        actualizado.setDni(modelo.getDni());
        actualizado.setMail(modelo.getMail());
        repositorio.save(actualizado);
    }

    public void update(@PathVariable Long id, @RequestBody ClienteM modelo){
        ClienteM actualizado = repositorio.findById(id).get();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        actualizado.setCliente(modelo.isCliente());
        actualizado.setPendiente(modelo.isPendiente());
        actualizado.setDni(modelo.getDni());
        actualizado.setMail(modelo.getMail());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }

    public ClienteM encontrarXnombreUsuarioCliente(String nombre_usuario){
        return repositorio.findByNombreUsuario(nombre_usuario);
    }

    public Optional<ClienteM> encontrarXid(Long id) {
        return repositorio.findById(id);
    }

    public ClienteM encontrarXnombreUsuarioEmpleado(String nombre_usuario) {
        return repositorio.findByNombreUsuario(nombre_usuario);
    }
}
