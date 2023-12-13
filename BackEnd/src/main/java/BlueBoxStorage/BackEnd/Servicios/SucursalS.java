package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.SucursalM;
import BlueBoxStorage.BackEnd.Repositorios.SucursalR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SucursalS {
    @Autowired(required=false)
    private SucursalR repositorio;

    @Autowired(required=false)
    SucursalZonaS sucursalZonaS;

    public List<SucursalM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody SucursalM modelo){
        repositorio.save(modelo);
    }

    public void update(@PathVariable Long id, @RequestBody SucursalM modelo){
        SucursalM actualizado = repositorio.findByIdSucursal(id);
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id_sucursal){
        repositorio.deleteByIdSucursal(id_sucursal);
    }

    public SucursalM obtenerSucursalPerteneciente(Long idZona){
        return repositorio.obtenerSucursalPerteneciente(idZona);
    }
}
