package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.SucursalM;
import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Repositorios.SucursalR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SucursalS {
    @Autowired
    private SucursalR repositorio;

    public List<SucursalM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody SucursalM modelo){
        repositorio.save(modelo);
    }

    public void update(@PathVariable Long id, @RequestBody SucursalM modelo){
        SucursalM actualizado = repositorio.findById(id).get();
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }
}
