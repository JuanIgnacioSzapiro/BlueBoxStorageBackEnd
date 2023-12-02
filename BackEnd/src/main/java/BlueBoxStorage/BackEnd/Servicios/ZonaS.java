package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Repositorios.ZonaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ZonaS {
    @Autowired
    private ZonaR repositorio;

    public List<ZonaM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody ZonaM modelo){
        repositorio.save(modelo);
    }

    public void update(@PathVariable Long id, @RequestBody ZonaM modelo){
        ZonaM actualizado = repositorio.findById(id).get();
        actualizado.setLetra(modelo.getLetra());
        actualizado.setTipo(modelo.getTipo());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }

    public List<ZonaM> encontrarZonasXIdSucursal(@PathVariable Long id){
        return repositorio.encontrarZonasXIdSucursal(id);
    }
}
