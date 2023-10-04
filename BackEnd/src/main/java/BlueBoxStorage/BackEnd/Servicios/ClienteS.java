package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.ClienteM;
import BlueBoxStorage.BackEnd.Modelos.RolM;
import BlueBoxStorage.BackEnd.Repositorios.ClienteR;
import BlueBoxStorage.BackEnd.Repositorios.RolR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ClienteS {
    @Autowired
    private ClienteR repositorio;

    @Autowired
    private RolR rolR;

    public List<ClienteM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody ClienteM modelo){
        RolM rolM = rolR.findByAutoridad("PENDIENTE").get();

        Set<RolM> autoridades = new HashSet<>();
        autoridades.add(rolM);

        ClienteM actualizado = new ClienteM();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        actualizado.setAutoridades(autoridades);
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
        actualizado.setAutoridades(modelo.getAutoridades());
        actualizado.setDni(modelo.getDni());
        actualizado.setMail(modelo.getMail());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }
}
